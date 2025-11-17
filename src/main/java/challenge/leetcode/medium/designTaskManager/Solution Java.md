
<details>
  <summary>Version 1: 483ms</summary>
  
  ```java

/**
 * @implNote
 * <ul>
 * 		<li>TreeSet<Task> <code>tasks</code> keeps tasks ordered by (priority desc, taskId desc).</li>
 * 		<li>Map<Integer, Task> <code>taskIdMap</code> provides O(1) lookup for edit/remove.</li>
 * 		<li>When editing a task's priority, remove it from the TreeSet first, mutate, then re-add to keep ordering valid.</li>
 * </ul>
 */
class TaskManager
{
	private static final class Task
	{
		final int userId;
		final int taskId;
		int priority;

		Task(int userId, int taskId, int priority)
		{
			this.userId = userId;
			this.taskId = taskId;
			this.priority = priority;
		}

		@Override
		public String toString()
		{
			return String.format("%12s %12s %12s", userId, taskId, priority);
		}
	}

	// Highest priority first, then highest taskId first
	private static final Comparator<Task> ORDER = Comparator.<Task>comparingInt(t -> t.priority)
			.thenComparingInt(t -> t.taskId).reversed();

	private final TreeSet<Task> tasks = new TreeSet<>(ORDER);
	private final Map<Integer, Task> taskIdMap = new HashMap<>();

	public TaskManager(List<List<Integer>> tasks)
	{
		if (tasks != null)
		{
			for (List<Integer> t : tasks)
			{
				if (t == null || t.size() != 3)
				{
					continue;
				}
				add(t.get(0), t.get(1), t.get(2));
			}
		}
	}

	// Adds a new task. Assumes taskId is not already present.
	public void add(int userId, int taskId, int priority)
	{
		Task t = new Task(userId, taskId, priority);
		taskIdMap.put(taskId, t);
		tasks.add(t);
	}

	// Updates the priority of an existing task.
	public void edit(int taskId, int newPriority)
	{
		Task t = taskIdMap.get(taskId);
		if (t == null)
		{
			// per constraints this shouldn't happen
			return;
		}
		tasks.remove(t);
		t.priority = newPriority;
		tasks.add(t);
	}

	// Removes an existing task.
	public void rmv(int taskId)
	{
		Task t = taskIdMap.remove(taskId);
		if (t == null)
		{
			// per constraints this shouldn't happen
			return;
		}
		tasks.remove(t);
	}

	// Executes and removes the highest priority task,
	// returning its userId. If none, returns -1.
	public int execTop()
	{
		if (tasks.isEmpty())
		{
			return -1;
		}

		// The heap's comparator self-balances such that
		// first() yields the highest-priority, then by highest taskId
		Task top = tasks.first();
		tasks.remove(top);
		taskIdMap.remove(top.taskId);
		return top.userId;
	}

	public void inspect()
	{
		Task top = tasks.first();
		System.out.printf("%n              %12s %12s %12s%n", "USER ID", "TASK ID", "PRIORITY");
		for (Task t : tasks)
		{
			System.out.printf("              %s%n", t.toString());
		}
	}
}


```
  
</details>

<br>

<details>
  <summary>Version 2: 417ms</summary>

```java

class TaskManager
{
	// Heap is 1-indexed to simplify parent/child math.
	private int[] user;     // userId at heap index i
	private int[] task;     // taskId at heap index i
	private int[] prio;     // priority at heap index i
	private int size;       // current heap size

	// taskId -> heap index
	private final Map<Integer, Integer> pos = new HashMap<>();

	public TaskManager(List<List<Integer>> tasks)
	{
		int init = tasks == null ? 0 : tasks.size();
		int cap = Math.max(16, init + 4);
		user = new int[cap];
		task = new int[cap];
		prio = new int[cap];
		size = 0;

		if (tasks != null)
		{
			for (List<Integer> t : tasks)
			{
				if (t == null || t.size() != 3) continue;
				add(t.get(0), t.get(1), t.get(2));
			}
		}
	}

	// Public API

	public void add(int userId, int taskId, int priority)
	{
		ensureCapacity(size + 1);
		int i = ++size;
		user[i] = userId;
		task[i] = taskId;
		prio[i] = priority;
		pos.put(taskId, i);
		siftUp(i);
	}

	public void edit(int taskId, int newPriority)
	{
		Integer idx = pos.get(taskId);
		if (idx == null) return; // per constraints, shouldn't happen
		int i = idx;
		int old = prio[i];
		if (old == newPriority) return;
		prio[i] = newPriority;
		// Decide direction to maintain heap property
		int parent = i >> 1;
		if (i > 1 && isHigher(i, parent)) {
			siftUp(i);
		} else {
			siftDown(i);
		}
	}

	public void remove(int taskId)
	{
		Integer idx = pos.remove(taskId);
		if (idx == null) return; // per constraints, shouldn't happen
		int i = idx;
		if (i == size) { // removing the last element
			size--;
			return;
		}
		swap(i, size); // moved something else into i
		size--;
		// Fix position i
		int parent = i >> 1;
		if (i > 1 && isHigher(i, parent)) {
			siftUp(i);
		} else {
			siftDown(i);
		}
	}

	public int executeTop()
	{
		if (size == 0) return -1;
		int topUser = user[1];
		int topTaskId = task[1];
		pos.remove(topTaskId);

		if (size == 1) {
			size = 0;
			return topUser;
		}

		swap(1, size);
		size--;
		siftDown(1);
		return topUser;
	}

	// Heap internals

	private void siftUp(int i)
	{
		while (i > 1) {
			int p = i >> 1;
			if (isHigher(p, i)) break;
			swap(i, p);
			i = p;
		}
	}

	private void siftDown(int i)
	{
		while (true) {
			int left = i << 1;
			if (left > size) break;
			int right = left + 1;
			int best = left;
			if (right <= size && isHigher(right, left)) best = right;
			if (isHigher(i, best)) break;
			swap(i, best);
			i = best;
		}
	}

	// Return true if node at a has higher priority than node at b
	// Higher priority = larger prio; tie-breaker = larger taskId
	private boolean isHigher(int a, int b)
	{
		int pa = prio[a], pb = prio[b];
		if (pa != pb) return pa > pb;
		return task[a] > task[b];
	}

	private void swap(int i, int j)
	{
		if (i == j) return;

		int ti = task[i], tj = task[j];

		int tmp;

		tmp = user[i]; user[i] = user[j]; user[j] = tmp;
		tmp = task[i]; task[i] = task[j]; task[j] = tmp;
		tmp = prio[i]; prio[i] = prio[j]; prio[j] = tmp;

		// Update positions for the two taskIds that just moved
		pos.put(ti, j);
		pos.put(tj, i);
	}

	private void ensureCapacity(int requiredIndex)
	{
		if (requiredIndex < user.length) return;
		int newCap = Math.max(user.length << 1, requiredIndex + 1);
		user = Arrays.copyOf(user, newCap);
		task = Arrays.copyOf(task, newCap);
		prio = Arrays.copyOf(prio, newCap);
	}
}

```

</details>

<br>

<details>
  <summary>Version 3: 433ms</summary>
  
```java

class TaskManager
{
	// Per constraints
	private static final int MAX_TASK_ID = 100_000;

	// 1-indexed heap arrays
	private final int[] user;  // userId at heap index i
	private final int[] task;  // taskId at heap index i
	private final int[] prio;  // priority at heap index i
	private int size;

	// Direct addressing: taskId -> heap index (0 => not present)
	private final int[] pos;

	public TaskManager(List<List<Integer>> tasks)
	{
		// Preallocate to the hard upper bound from constraints so we never resize/copy.
		int cap = MAX_TASK_ID + 5; // small slack
		user = new int[cap];
		task = new int[cap];
		prio = new int[cap];
		pos  = new int[MAX_TASK_ID + 1];
		size = 0;

		if (tasks != null)
		{
			for (List<Integer> t : tasks)
			{
				if (t == null || t.size() != 3) continue;
				add(t.get(0), t.get(1), t.get(2));
			}
		}
	}

	// Adds a new task. Assumes taskId unique and within [1..MAX_TASK_ID].
	public void add(int userId, int taskId, int priority)
	{
		// Defensive checks can be removed for even more speed in trusted contexts.
		if (taskId <= 0 || taskId > MAX_TASK_ID)
			throw new IllegalArgumentException("taskId out of range: " + taskId);
		if (pos[taskId] != 0)
			throw new IllegalStateException("taskId already exists: " + taskId);

		int i = ++size;
		user[i] = userId;
		task[i] = taskId;
		prio[i] = priority;
		pos[taskId] = i;
		siftUp(i);
	}

	// Updates priority of an existing task.
	public void edit(int taskId, int newPriority)
	{
		int i = posSafe(taskId);
		int old = prio[i];
		if (old == newPriority) return;

		prio[i] = newPriority;

		// Decide direction based on local heap relationships to minimize swaps
		int p = i >>> 1;
		if (i > 1 && isHigher(i, p)) {
			siftUp(i);
		} else {
			siftDown(i);
		}
	}

	// Removes an existing task.
	public void remove(int taskId)
	{
		int i = posSafe(taskId);
		pos[taskId] = 0;

		if (i == size) {
			size--;
			return;
		}

		swap(i, size);
		size--;

		int p = i >>> 1;
		if (i > 1 && isHigher(i, p)) {
			siftUp(i);
		} else {
			siftDown(i);
		}
	}

	// Executes and removes highest-priority task; tie -> highest taskId. Returns userId or -1 if none.
	public int executeTop()
	{
		if (size == 0) return -1;

		int topUser = user[1];
		int topTask = task[1];
		pos[topTask] = 0;

		if (size == 1) {
			size = 0;
			return topUser;
		}

		swap(1, size);
		size--;
		siftDown(1);
		return topUser;
	}

	// --------- Heap internals (hot paths) ---------

	private void siftUp(int i)
	{
		while (i > 1) {
			int p = i >>> 1;
			if (isHigher(p, i)) break;
			swap(i, p);
			i = p;
		}
	}

	private void siftDown(int i)
	{
		while (true) {
			int l = i << 1;
			if (l > size) break;
			int r = l + 1;

			// choose higher child
			int best = l;
			if (r <= size && isHigher(r, l)) best = r;

			if (isHigher(i, best)) break;
			swap(i, best);
			i = best;
		}
	}

	// Comparison inlined for speed: higher prio wins; tie -> higher taskId wins.
	private boolean isHigher(int a, int b)
	{
		int pa = prio[a], pb = prio[b];
		return (pa > pb) || (pa == pb && task[a] > task[b]);
	}

	private void swap(int i, int j)
	{
		if (i == j) return;

		int ti = task[i];
		int tj = task[j];

		int tmp;

		tmp = user[i]; user[i] = user[j]; user[j] = tmp;
		tmp = task[i]; task[i] = task[j]; task[j] = tmp;
		tmp = prio[i]; prio[i] = prio[j]; prio[j] = tmp;

		pos[ti] = j;
		pos[tj] = i;
	}

	private int posSafe(int taskId)
	{
		int i = (taskId >= 1 && taskId <= MAX_TASK_ID) ? pos[taskId] : 0;
		if (i == 0) throw new IllegalStateException("taskId not found: " + taskId);
		return i;
	}
}

```  
  
</details>

<br>

<details>
  <summary>Version 4: TLE</summary>
  
```java

class TaskManager
{
    // Heap arrays - 1-indexed for simpler parent/child calculations
    private int[] user;
    private int[] task;
    private int[] prio;
    private int size;

    // Custom hash table for taskId -> heap index mapping
    // Using open addressing with linear probing for better cache locality
    private int[] hashKeys;    // taskId values
    private int[] hashValues;  // heap index values
    private int hashCapacity;
    private int hashSize;
    private static final int DELETED_KEY = Integer.MIN_VALUE;
    private static final int EMPTY_KEY = 0;

    public TaskManager(List<List<Integer>> tasks)
    {
        int initialSize = tasks == null ? 0 : tasks.size();
        initializeArrays(Math.max(16, initialSize + 4));
        initializeHashTable(Math.max(32, initialSize * 4)); // Load factor ~0.25 for performance

        if (tasks != null)
        {
            for (List<Integer> t : tasks)
            {
                if (t != null && t.size() == 3)
                {
                    add(t.get(0), t.get(1), t.get(2));
                }
            }
        }
    }

    private void initializeArrays(int capacity)
    {
        user = new int[capacity];
        task = new int[capacity];
        prio = new int[capacity];
        size = 0;
    }

    private void initializeHashTable(int capacity)
    {
        // Ensure capacity is power of 2 for fast modulo
        hashCapacity = Integer.highestOneBit(capacity - 1) << 1;
        hashKeys = new int[hashCapacity];
        hashValues = new int[hashCapacity];
        hashSize = 0;
        // Arrays are zero-initialized, EMPTY_KEY = 0
    }

    // Public API

    public void add(int userId, int taskId, int priority)
    {
        ensureHeapCapacity(size + 1);
        ensureHashCapacity();

        int i = ++size;
        user[i] = userId;
        task[i] = taskId;
        prio[i] = priority;
        
        hashPut(taskId, i);
        siftUp(i);
    }

    public void edit(int taskId, int newPriority)
    {
        int i = hashGet(taskId);
        if (i == -1) return;
        
        int oldPriority = prio[i];
        if (oldPriority == newPriority) return;
        
        prio[i] = newPriority;
        
        // Determine sift direction more efficiently
        if (newPriority > oldPriority)
        {
            siftUp(i);
        }
        else
        {
            siftDown(i);
        }
    }

    public void remove(int taskId)
    {
        int i = hashGet(taskId);
        if (i == -1) return;
        
        hashRemove(taskId);
        
        if (i == size)
        {
            size--;
            return;
        }
        
        // Move last element to removed position
        user[i] = user[size];
        task[i] = task[size];
        prio[i] = prio[size];
        
        // Update hash table for moved task
        hashPut(task[i], i);
        size--;
        
        // Restore heap property
        if (i > 1 && compareNodes(i, i >> 1) > 0)
        {
            siftUp(i);
        }
        else
        {
            siftDown(i);
        }
    }

    public int executeTop()
    {
        if (size == 0) return -1;
        
        int topUser = user[1];
        int topTaskId = task[1];
        
        hashRemove(topTaskId);
        
        if (size == 1)
        {
            size = 0;
            return topUser;
        }
        
        // Move last element to root
        user[1] = user[size];
        task[1] = task[size];
        prio[1] = prio[size];
        
        // Update hash table for moved task
        hashPut(task[1], 1);
        size--;
        
        siftDown(1);
        return topUser;
    }

    // Optimized heap operations

    private void siftUp(int i)
    {
        int currentUser = user[i];
        int currentTask = task[i];
        int currentPrio = prio[i];
        
        while (i > 1)
        {
            int parent = i >> 1;
            
            // Inline comparison for better performance
            int parentPrio = prio[parent];
            if (parentPrio > currentPrio || 
                (parentPrio == currentPrio && task[parent] >= currentTask))
            {
                break;
            }
            
            // Move parent down
            user[i] = user[parent];
            task[i] = task[parent];
            prio[i] = prio[parent];
            hashPut(task[i], i);
            
            i = parent;
        }
        
        // Place current element in final position
        user[i] = currentUser;
        task[i] = currentTask;
        prio[i] = currentPrio;
        hashPut(currentTask, i);
    }

    private void siftDown(int i)
    {
        int currentUser = user[i];
        int currentTask = task[i];
        int currentPrio = prio[i];
        
        int half = size >> 1;
        while (i <= half)
        {
            int left = i << 1;
            int right = left + 1;
            int maxChild = left;
            
            // Find child with higher priority
            if (right <= size)
            {
                int leftPrio = prio[left];
                int rightPrio = prio[right];
                if (rightPrio > leftPrio || 
                    (rightPrio == leftPrio && task[right] > task[left]))
                {
                    maxChild = right;
                }
            }
            
            // Check if current node should stay
            int childPrio = prio[maxChild];
            if (currentPrio > childPrio || 
                (currentPrio == childPrio && currentTask >= task[maxChild]))
            {
                break;
            }
            
            // Move child up
            user[i] = user[maxChild];
            task[i] = task[maxChild];
            prio[i] = prio[maxChild];
            hashPut(task[i], i);
            
            i = maxChild;
        }
        
        // Place current element in final position
        user[i] = currentUser;
        task[i] = currentTask;
        prio[i] = currentPrio;
        hashPut(currentTask, i);
    }

    private int compareNodes(int a, int b)
    {
        int prioA = prio[a], prioB = prio[b];
        if (prioA != prioB) return Integer.compare(prioA, prioB);
        return Integer.compare(task[a], task[b]);
    }

    // Custom hash table implementation

    private void hashPut(int key, int value)
    {
        int index = hashIndex(key);
        
        while (hashKeys[index] != EMPTY_KEY && hashKeys[index] != DELETED_KEY)
        {
            if (hashKeys[index] == key)
            {
                hashValues[index] = value;
                return;
            }
            index = (index + 1) & (hashCapacity - 1);
        }
        
        if (hashKeys[index] == EMPTY_KEY || hashKeys[index] == DELETED_KEY)
        {
            if (hashKeys[index] == EMPTY_KEY) hashSize++;
            hashKeys[index] = key;
            hashValues[index] = value;
        }
    }

    private int hashGet(int key)
    {
        int index = hashIndex(key);
        
        while (hashKeys[index] != EMPTY_KEY)
        {
            if (hashKeys[index] == key)
            {
                return hashValues[index];
            }
            index = (index + 1) & (hashCapacity - 1);
        }
        
        return -1;
    }

    private void hashRemove(int key)
    {
        int index = hashIndex(key);
        
        while (hashKeys[index] != EMPTY_KEY)
        {
            if (hashKeys[index] == key)
            {
                hashKeys[index] = DELETED_KEY;
                return;
            }
            index = (index + 1) & (hashCapacity - 1);
        }
    }

    private int hashIndex(int key)
    {
        // Simple but effective hash function
        return (key ^ (key >>> 16)) & (hashCapacity - 1);
    }

    private void ensureHeapCapacity(int requiredSize)
    {
        if (requiredSize < user.length) return;
        
        int newCapacity = Math.max(user.length << 1, requiredSize + 1);
        user = Arrays.copyOf(user, newCapacity);
        task = Arrays.copyOf(task, newCapacity);
        prio = Arrays.copyOf(prio, newCapacity);
    }

    private void ensureHashCapacity()
    {
        if (hashSize * 4 < hashCapacity * 3) return; // Load factor < 0.75
        
        int oldCapacity = hashCapacity;
        int[] oldKeys = hashKeys;
        int[] oldValues = hashValues;
        
        initializeHashTable(hashCapacity << 1);
        
        // Rehash all entries
        for (int i = 0; i < oldCapacity; i++)
        {
            if (oldKeys[i] != EMPTY_KEY && oldKeys[i] != DELETED_KEY)
            {
                hashPut(oldKeys[i], oldValues[i]);
            }
        }
    }
}

```
  
</details>

<br>

<details>
  <summary>Verison 5: 291ms</summary>
  
```java

class TaskManager
{
	// Constraints
	private static final int MAX_TASK_ID = 100_000; // direct-address map size
	private static final int KEY_SHIFT = 20;        // 2^20 = 1,048,576 > max taskId (1e5), Encodes tie-break cleanly

	// Heap arrays (1-indexed)
	private final int[] user;   // userId at heap index i
	private final int[] task;   // taskId at heap index i
	private final int[] prio;   // priority at heap index i
	private final long[] key;   // composite key = ((long)priority << KEY_SHIFT) | taskId

	// Direct-address position map: pos[taskId] = heap index (0 if absent)
	private final int[] pos;

	private int size; // number of elements in heap

	public TaskManager(List<List<Integer>> tasks)
	{
		int initial = tasks == null ? 0 : tasks.size();

		// Worst-case concurrent tasks: initial + (at most 2e5 adds)
		// + 5 buffer, + 1 since heap is 1-indexed
		int cap = Math.max(16, initial + 200_000 + 5) + 1;

		this.user = new int[cap];
		this.task = new int[cap];
		this.prio = new int[cap];
		this.key = new long[cap];
		this.pos = new int[MAX_TASK_ID + 5];

		this.size = 0;

		if (tasks != null)
		{
			for (int i = 0, n = tasks.size(); i < n; i++)
			{
				List<Integer> t = tasks.get(i);
				if (t == null || t.size() != 3)
				{
					continue;
				}
				add(t.get(0), t.get(1), t.get(2));
			}
		}
	}

	// Adds a new task. Assumes unique taskId (per constraints).
	public final void add(int userId, int taskId, int priority)
	{
		int i = ++size;
		user[i] = userId;
		task[i] = taskId;
		prio[i] = priority;
		key[i] = packKey(priority, taskId);
		pos[taskId] = i;
		siftUp(i);
	}

	// Updates priority of an existing task.
	public final void edit(int taskId, int newPriority)
	{
		int i = pos[taskId];
		if (i == 0)
		{
			return; // per constraints, shouldn't happen
		}

		prio[i] = newPriority;
		key[i] = packKey(newPriority, taskId);

		int parent = i >>> 1;
		if (i > 1 && key[i] > key[parent])
		{
			siftUp(i);
		}
		else
		{
			siftDown(i);
		}
	}

	// Remove task by id
	public final void rmv(int taskId)
	{
		int i = pos[taskId];
		if (i == 0)
		{
			return; // per constraints
		}

		pos[taskId] = 0;

		if (i == size)
		{ // last element
			size--;
			return;
		}

		// Move last element into i and fix heap
		int lu = user[size];
		int lt = task[size];
		int lp = prio[size];
		long lk = key[size];
		size--;

		user[i] = lu;
		task[i] = lt;
		prio[i] = lp;
		key[i] = lk;
		pos[lt] = i;

		int parent = i >>> 1;
		if (i > 1 && key[i] > key[parent])
		{
			siftUp(i);
		}
		else
		{
			siftDown(i);
		}
	}

	// Executes highest priority (tie: highest taskId)
	// Returns userId or -1 if empty (shouldn't occur according to problem statement though)
	public final int execTop()
	{
		if (size == 0)
		{
			return -1;
		}

		int topUser = user[1];
		int topTask = task[1];

		pos[topTask] = 0;

		if (size == 1)
		{
			size = 0;
			return topUser;
		}

		// Move last element to root and siftDown
		int lu = user[size];
		int lt = task[size];
		int lp = prio[size];
		long lk = key[size];
		size--;

		user[1] = lu;
		task[1] = lt;
		prio[1] = lp;
		key[1] = lk;
		pos[lt] = 1;

		siftDown(1);
		return topUser;
	}

	// ---------- Heap helpers (bubble with single writeback) ----------

	private void siftUp(int i)
	{
		int u = user[i];
		int t = task[i];
		int p = prio[i];
		long k = key[i];

		while (i > 1)
		{
			int parent = i >>> 1;
			if (key[parent] >= k)
			{
				break;
			}

			// Move parent down
			user[i] = user[parent];
			task[i] = task[parent];
			prio[i] = prio[parent];
			key[i] = key[parent];
			pos[task[i]] = i;

			i = parent;
		}

		// Place saved node
		user[i] = u;
		task[i] = t;
		prio[i] = p;
		key[i] = k;
		pos[t] = i;
	}

	private void siftDown(int i)
	{
		int u = user[i];
		int t = task[i];
		int p = prio[i];
		long k = key[i];

		while (true)
		{
			int left = i << 1;
			if (left > size)
			{
				break;
			}

			int right = left + 1;
			int best = left;

			if (right <= size && key[right] > key[left])
			{
				best = right;
			}

			if (key[best] <= k)
			{
				break;
			}

			// Move best child up
			user[i] = user[best];
			task[i] = task[best];
			prio[i] = prio[best];
			key[i] = key[best];
			pos[task[i]] = i;

			i = best;
		}

		// Place saved node
		user[i] = u;
		task[i] = t;
		prio[i] = p;
		key[i] = k;
		pos[t] = i;
	}

	private static long packKey(int priority, int taskId)
	{
		// Higher priority => bigger key; tie => higher taskId => bigger key
		return (((long) priority) << KEY_SHIFT) | (taskId & 0xFFFFF);
	}
}

```  
  
</details>

<br>

<details>
  <summary>Version 5: 309 ms</summary>
  
```java

class TaskManager
{
	private static final int MAX_TASK_ID = 100_000;
	private static final int KEY_SHIFT = 17;

	private int[] user;
	private int[] task;
	private int[] prio;
	private long[] key;

	private final int[] pos;

	private int size;

	public TaskManager(List<List<Integer>> tasks)
	{
		final int initial = (tasks == null) ? 0 : tasks.size();

		int cap = Math.max(32, initial + 200_000 + 8) + 1;

		this.user = new int[cap];
		this.task = new int[cap];
		this.prio = new int[cap];
		this.key = new long[cap];
		this.pos = new int[MAX_TASK_ID + 5];

		this.key[0] = Long.MAX_VALUE;

		if (initial == 0 || tasks == null)
		{
			this.size = 0;
			return;
		}

		int i = 1;
		for (int k = 0; k < initial; k++)
		{
			List<Integer> t = tasks.get(k);
			if (t == null || t.size() != 3)
			{
				continue;
			}

			int uId = t.get(0);
			int tId = t.get(1);
			int pr = t.get(2);

			user[i] = uId;
			task[i] = tId;
			prio[i] = pr;
			key[i] = packKey(pr, tId);
			pos[tId] = i;
			i++;
		}
		this.size = i - 1;

		for (int j = size >>> 1; j >= 1; j--)
		{
			siftDown(j);
		}
	}

	public final void add(int userId, int taskId, int priority)
	{
		int i = ++size;

		if (i == user.length)
		{
			grow();
		}

		user[i] = userId;
		task[i] = taskId;
		prio[i] = priority;
		key[i] = packKey(priority, taskId);
		pos[taskId] = i;
		siftUp(i);
	}

	public final void edit(int taskId, int newPriority)
	{
		int i = pos[taskId];
		if (i == 0)
		{
			return;
		}

		prio[i] = newPriority;
		key[i] = packKey(newPriority, taskId);

		int parent = i >>> 1;
		if (key[i] > key[parent])
		{
			siftUp(i);
		}
		else
		{
			siftDown(i);
		}
	}

	public final void rmv(int taskId)
	{
		int i = pos[taskId];
		if (i == 0)
		{
			return;
		}

		pos[taskId] = 0;

		if (i == size)
		{
			size--;
			return;
		}

		int lu = user[size];
		int lt = task[size];
		int lp = prio[size];
		long lk = key[size];
		size--;

		user[i] = lu;
		task[i] = lt;
		prio[i] = lp;
		key[i] = lk;
		pos[lt] = i;

		int parent = i >>> 1;
		if (key[i] > key[parent])
		{
			siftUp(i);
		}
		else
		{
			siftDown(i);
		}
	}

	public final int execTop()
	{
		if (size == 0)
		{
			return -1;
		}

		int topUser = user[1];
		int topTask = task[1];

		pos[topTask] = 0;

		if (size == 1)
		{
			size = 0;
			return topUser;
		}

		int lu = user[size];
		int lt = task[size];
		int lp = prio[size];
		long lk = key[size];
		size--;

		user[1] = lu;
		task[1] = lt;
		prio[1] = lp;
		key[1] = lk;
		pos[lt] = 1;

		siftDown(1);
		return topUser;
	}


	private void siftUp(int i)
	{
		int u = user[i];
		int t = task[i];
		int p = prio[i];
		long k = key[i];

		for (int parent = i >>> 1; k > key[parent]; parent = (i >>> 1))
		{
			user[i] = user[parent];
			task[i] = task[parent];
			prio[i] = prio[parent];
			key[i] = key[parent];
			pos[task[i]] = i;

			i = parent;
		}

		user[i] = u;
		task[i] = t;
		prio[i] = p;
		key[i] = k;
		pos[t] = i;
	}

	private void siftDown(int i)
	{
		int u = user[i];
		int t = task[i];
		int p = prio[i];
		long k = key[i];

		while (true)
		{
			int left = i << 1;
			if (left > size)
			{
				break;
			}

			int right = left + 1;
			int best = left;

			if (right <= size && key[right] > key[left])
			{
				best = right;
			}

			if (key[best] <= k)
			{
				break;
			}

			user[i] = user[best];
			task[i] = task[best];
			prio[i] = prio[best];
			key[i] = key[best];
			pos[task[i]] = i;

			i = best;
		}

		user[i] = u;
		task[i] = t;
		prio[i] = p;
		key[i] = k;
		pos[t] = i;
	}

	private static long packKey(int priority, int taskId)
	{
		return (((long) priority) << KEY_SHIFT) + (taskId & 0x1FFFFL);
	}

	private void grow()
	{
		int newCap = user.length << 1;

		int[] nu = new int[newCap];
		int[] nt = new int[newCap];
		int[] np = new int[newCap];
		long[] nk = new long[newCap];

		System.arraycopy(user, 0, nu, 0, user.length);
		System.arraycopy(task, 0, nt, 0, task.length);
		System.arraycopy(prio, 0, np, 0, prio.length);
		System.arraycopy(key, 0, nk, 0, key.length);

		forceAssign(nu, nt, np, nk);
	}

	@SuppressWarnings("all")
	private void forceAssign(int[] nu, int[] nt, int[] np, long[] nk)
	{
		this.user = nu;
		this.task = nt;
		this.prio = np;
		this.key = nk;
	}
}

```
  
</details>

<br>

<details>
  <summary>Version 6: 242ms</summary>
  
```java

class TaskManager
{
	// Constraints
	private static final int MAX_TASK_ID = 100_000;
	// 2^17 = 131,072 > MAX_TASK_ID, so 17 bits is enough to encode taskId
	private static final int KEY_SHIFT = 17;

	// If initial tasks >= this threshold, use O(n) heapify; otherwise, push via add()
	private static final int HEAPIFY_THRESHOLD = 2048;

	// Heap arrays (1-indexed)
	private int[]  user;
	private int[]  task;
	private int[]  prio;
	private long[] key;   // composite = ((long)priority << KEY_SHIFT) | taskId (higher is better)

	// taskId -> heap index (0 if absent)
	private final int[] pos = new int[MAX_TASK_ID + 1];

	private int size;

	// Default constructor with adaptive capacity; good for mixed/small tests
	public TaskManager(List<List<Integer>> tasks)
	{
		this(tasks, -1);
	}

	// Overload that lets you pre-size for very large scenarios to avoid early growth copies
	public TaskManager(List<List<Integer>> tasks, int expectedMaxConcurrentTasks)
	{
		int initial = (tasks == null) ? 0 : tasks.size();
		int cap = initialCapacity(initial, expectedMaxConcurrentTasks);

		this.user = new int[cap];
		this.task = new int[cap];
		this.prio = new int[cap];
		this.key  = new long[cap];
		this.size = 0;

		if (tasks == null || initial == 0) return;

		if (initial >= HEAPIFY_THRESHOLD)
		{
			// Bulk load then O(n) heapify
			int i = 1;
			for (int k = 0; k < initial; k++)
			{
				List<Integer> t = tasks.get(k);
				if (t == null || t.size() != 3) continue;
				int u = t.get(0);
				int id = t.get(1);
				int p = t.get(2);
				ensureCapacity(i);
				user[i] = u;
				task[i] = id;
				prio[i] = p;
				key[i]  = packKey(p, id);
				pos[id] = i;
				i++;
			}
			size = i - 1;
			for (int j = size >>> 1; j >= 1; j--) {
				siftDown(j);
			}
		}
		else
		{
			// Small initial sets: cheaper to use incremental adds
			for (int k = 0; k < initial; k++)
			{
				List<Integer> t = tasks.get(k);
				if (t == null || t.size() != 3) continue;
				add(t.get(0), t.get(1), t.get(2));
			}
		}
	}

	// API

	public final void add(int userId, int taskId, int priority)
	{
		int i = ++size;
		ensureCapacity(i);
		user[i] = userId;
		task[i] = taskId;
		prio[i] = priority;
		key[i]  = packKey(priority, taskId);
		pos[taskId] = i;
		siftUp(i);
	}

	public final void edit(int taskId, int newPriority)
	{
		int i = pos[taskId];
		if (i == 0) return; // per constraints shouldn't happen

		prio[i] = newPriority;
		key[i]  = packKey(newPriority, taskId);

		int parent = i >>> 1;
		// Decide direction with a single parent check; children handled by siftDown if needed
		if (i > 1 && key[i] > key[parent]) {
			siftUp(i);
		} else {
			siftDown(i);
		}
	}

	public final void remove(int taskId)
	{
		int i = pos[taskId];
		if (i == 0) return; // per constraints

		pos[taskId] = 0;

		if (i == size) {
			size--;
			return;
		}

		// Move last to i, then fix in whichever direction is needed
		int lu = user[size];
		int lt = task[size];
		int lp = prio[size];
		long lk = key[size];
		size--;

		user[i] = lu;
		task[i] = lt;
		prio[i] = lp;
		key[i]  = lk;
		pos[lt] = i;

		int parent = i >>> 1;
		if (i > 1 && key[i] > key[parent]) {
			siftUp(i);
		} else {
			siftDown(i);
		}
	}

	public final int executeTop()
	{
		if (size == 0) return -1;

		int topUser = user[1];
		int topTask = task[1];
		pos[topTask] = 0;

		if (size == 1) {
			size = 0;
			return topUser;
		}

		// Move last to root and siftDown
		int lu = user[size];
		int lt = task[size];
		int lp = prio[size];
		long lk = key[size];
		size--;

		user[1] = lu;
		task[1] = lt;
		prio[1] = lp;
		key[1]  = lk;
		pos[lt] = 1;

		siftDown(1);
		return topUser;
	}

	// -------- Heap internals: bubble with single writeback --------

	private void siftUp(int i)
	{
		int u = user[i];
		int t = task[i];
		int p = prio[i];
		long k = key[i];

		while (i > 1) {
			int parent = i >>> 1;
			if (key[parent] >= k) break;

			// Move parent down
			user[i] = user[parent];
			task[i] = task[parent];
			prio[i] = prio[parent];
			key[i]  = key[parent];
			pos[task[i]] = i;

			i = parent;
		}

		user[i] = u;
		task[i] = t;
		prio[i] = p;
		key[i]  = k;
		pos[t] = i;
	}

	private void siftDown(int i)
	{
		int u = user[i];
		int t = task[i];
		int p = prio[i];
		long k = key[i];

		while (true) {
			int left = i << 1;
			if (left > size) break;

			int right = left + 1;
			int best = left;
			if (right <= size && key[right] > key[left]) best = right;

			if (key[best] <= k) break;

			// Move best child up
			user[i] = user[best];
			task[i] = task[best];
			prio[i] = prio[best];
			key[i]  = key[best];
			pos[task[i]] = i;

			i = best;
		}

		user[i] = u;
		task[i] = t;
		prio[i] = p;
		key[i]  = k;
		pos[t] = i;
	}

	private static long packKey(int priority, int taskId)
	{
		// Higher priority => bigger key; tie => higher taskId => bigger key
		return (((long) priority) << KEY_SHIFT) | (taskId & 0x1FFFFL); // 17 bits of taskId
	}

	// -------- Capacity helpers --------

	private void ensureCapacity(int requiredIndex)
	{
		if (requiredIndex < user.length) return;
		int newCap = user.length << 1; // double
		if (newCap <= requiredIndex) newCap = requiredIndex + 1;

		int[] nu = new int[newCap];
		int[] nt = new int[newCap];
		int[] np = new int[newCap];
		long[] nk = new long[newCap];

		System.arraycopy(user, 0, nu, 0, user.length);
		System.arraycopy(task, 0, nt, 0, task.length);
		System.arraycopy(prio, 0, np, 0, prio.length);
		System.arraycopy(key,  0, nk, 0, key.length);

		user = nu; task = nt; prio = np; key = nk;
	}

	private static int initialCapacity(int initial, int expectedMaxConcurrentTasks)
	{
		if (expectedMaxConcurrentTasks > 0) {
			// Close fit if caller knows a large bound; +2 for 1-indexing and growth slop
			return Math.max(16, expectedMaxConcurrentTasks + 2);
		}
		// Tight, cache-friendly capacity for small tests; 1-indexed heap => +2
		int want = Math.max(16, initial + 8);
		// Round up to power of two for faster growth
		int cap = 1;
		while (cap < want) cap <<= 1;
		return cap;
	}
}

```
  
</details>


<br>

<details>
  <summary>Version 7: 220ms</summary>
  
```java

class TaskManager
{
	// Constraints
	private static final int MAX_TASK_ID = 100_000;
	private static final int KEY_SHIFT   = 17;      // 2^17 = 131072 > 1e5 (fits taskId)
	private static final long TASK_MASK  = (1L << KEY_SHIFT) - 1L;

	// If initial tasks >= this threshold, use O(n) heapify; else add() incrementally
	private static final int HEAPIFY_THRESHOLD = 2048;

	// Heap arrays (1-indexed)
	// key[i] = ((long)priority << KEY_SHIFT) | taskId
	private long[] key;
	// payload[i] packs (userId, taskId): high 32 bits = userId, low 32 bits = taskId
	private long[] payload;

	// Direct-address: taskId -> heap index (0 if absent)
	private final int[] pos = new int[MAX_TASK_ID + 1];

	private int size;

	// Default adaptive constructor
	public TaskManager(List<List<Integer>> tasks)
	{
		this(tasks, -1);
	}

	// Overload to pre-size if you know peak concurrent size
	public TaskManager(List<List<Integer>> tasks, int expectedMaxConcurrentTasks)
	{
		int initial = (tasks == null) ? 0 : tasks.size();
		int cap = initialCapacity(initial, expectedMaxConcurrentTasks);

		this.key     = new long[cap];
		this.payload = new long[cap];
		this.size    = 0;

		if (tasks == null || initial == 0) return;

		if (initial >= HEAPIFY_THRESHOLD)
		{
			// Bulk load then O(n) heapify
			int i = 1;
			for (int k = 0; k < initial; k++)
			{
				List<Integer> t = tasks.get(k);
				if (t == null || t.size() != 3) continue;
				int u = t.get(0);
				int id = t.get(1);
				int pr = t.get(2);
				ensureCapacity(i);
				key[i]     = packKey(pr, id);
				payload[i] = packPayload(u, id);
				pos[id]    = i;
				i++;
			}
			size = i - 1;
			for (int j = size >>> 1; j >= 1; j--) {
				siftDown(j);
			}
		}
		else
		{
			// Small initial sets: cheaper to use incremental adds
			for (int k = 0; k < initial; k++)
			{
				List<Integer> t = tasks.get(k);
				if (t == null || t.size() != 3) continue;
				add(t.get(0), t.get(1), t.get(2));
			}
		}
	}

	// API

	public final void add(int userId, int taskId, int priority)
	{
		int i = ++size;
		ensureCapacity(i);
		key[i]     = packKey(priority, taskId);
		payload[i] = packPayload(userId, taskId);
		pos[taskId] = i;
		siftUp(i);
	}

	public final void edit(int taskId, int newPriority)
	{
		int i = pos[taskId];
		if (i == 0) return; // per constraints, shouldn't happen

		key[i] = packKey(newPriority, taskId);

		int parent = i >>> 1;
		if (i > 1 && key[i] > key[parent]) {
			siftUp(i);
		} else {
			siftDown(i);
		}
	}

	public final void remove(int taskId)
	{
		int i = pos[taskId];
		if (i == 0) return;

		pos[taskId] = 0;

		if (i == size) {
			size--;
			return;
		}

		long lk = key[size];
		long lp = payload[size];
		int movedTask = (int) lp; // low 32 bits

		size--;

		key[i]     = lk;
		payload[i] = lp;
		pos[movedTask] = i;

		int parent = i >>> 1;
		if (i > 1 && key[i] > key[parent]) {
			siftUp(i);
		} else {
			siftDown(i);
		}
	}

	public final int executeTop()
	{
		if (size == 0) return -1;

		long rootPayload = payload[1];
		int topUser = (int) (rootPayload >>> 32);
		int topTask = (int) rootPayload;
		pos[topTask] = 0;

		if (size == 1) {
			size = 0;
			return topUser;
		}

		long lk = key[size];
		long lp = payload[size];
		int movedTask = (int) lp;

		size--;

		key[1]     = lk;
		payload[1] = lp;
		pos[movedTask] = 1;

		siftDown(1);
		return topUser;
	}

	// -------- Heap internals (bubble with single writeback) --------

	private void siftUp(int i)
	{
		long k = key[i];
		long pl = payload[i];
		int t = (int) pl;

		while (i > 1) {
			int p = i >>> 1;
			if (key[p] >= k) break;

			key[i]     = key[p];
			payload[i] = payload[p];
			pos[(int) payload[i]] = i;

			i = p;
		}

		key[i]     = k;
		payload[i] = pl;
		pos[t] = i;
	}

	private void siftDown(int i)
	{
		long k = key[i];
		long pl = payload[i];
		int t = (int) pl;

		while (true) {
			int left = i << 1;
			if (left > size) break;

			int right = left + 1;
			int best = left;
			if (right <= size && key[right] > key[left]) best = right;

			if (key[best] <= k) break;

			key[i]     = key[best];
			payload[i] = payload[best];
			pos[(int) payload[i]] = i;

			i = best;
		}

		key[i]     = k;
		payload[i] = pl;
		pos[t] = i;
	}

	// -------- Packing helpers --------

	private static long packKey(int priority, int taskId)
	{
		// Higher priority => bigger key; tie => higher taskId => bigger key
		return (((long) priority) << KEY_SHIFT) | (taskId & TASK_MASK);
	}

	private static long packPayload(int userId, int taskId)
	{
		return (((long) userId) << 32) | (taskId & 0xFFFF_FFFFL);
	}

	// -------- Capacity helpers --------

	private void ensureCapacity(int requiredIndex)
	{
		if (requiredIndex < key.length) return;

		int newCap = key.length << 1;
		if (newCap <= requiredIndex) newCap = requiredIndex + 1;

		long[] nk = new long[newCap];
		long[] np = new long[newCap];

		System.arraycopy(key,     0, nk, 0, key.length);
		System.arraycopy(payload, 0, np, 0, payload.length);

		key = nk; payload = np;
	}

	private static int initialCapacity(int initial, int expectedMaxConcurrentTasks)
	{
		if (expectedMaxConcurrentTasks > 0) {
			return Math.max(16, expectedMaxConcurrentTasks + 2);
		}
		int want = Math.max(16, initial + 8);
		int cap = 1;
		while (cap < want) cap <<= 1; // power-of-two growth for fewer resizes
		return cap;
	}
}

```
  
</details>

<br>

<details>
  <summary>Version 8: 214ms</summary>
  
```java

class TaskManager
{
	private static final int MAX_TASK_ID = 100_000;
	private static final int KEY_SHIFT = 17;
	private static final long TASK_MASK = (1L << KEY_SHIFT) - 1L;
	private final int smallThreshold;
	private long[] key;
	private long[] payload;
	private final int[] pos = new int[MAX_TASK_ID + 1];

	private int size;
	private boolean heapMode;

	public TaskManager(List<List<Integer>> tasks)
	{
		this(tasks, -1, 64);
	}

	public TaskManager(List<List<Integer>> tasks, int expectedMaxConcurrentTasks, int smallThreshold)
	{
		this.smallThreshold = Math.max(8, smallThreshold);

		int initial = (tasks == null) ? 0 : tasks.size();
		int cap = initialCapacity(initial, expectedMaxConcurrentTasks);

		this.key = new long[cap];
		this.payload = new long[cap];
		this.size = 0;
		this.heapMode = false;

		if (tasks == null || initial == 0)
		{
			return;
		}
		int i = 1;
		for (int k = 0; k < initial; k++)
		{
			List<Integer> t = tasks.get(k);
			if (t == null || t.size() != 3)
			{
				continue;
			}
			int u = t.get(0);
			int id = t.get(1);
			int pr = t.get(2);
			ensureCapacity(i);
			key[i] = packKey(pr, id);
			payload[i] = packPayload(u, id);
			pos[id] = i;
			i++;
		}
		size = i - 1;
		if (size > this.smallThreshold)
		{
			heapMode = true;
			heapify();
		}
	}

	public final void add(int userId, int taskId, int priority)
	{
		int i = ++size;
		ensureCapacity(i);
		long k = packKey(priority, taskId);
		long pl = packPayload(userId, taskId);
		key[i] = k;
		payload[i] = pl;
		pos[taskId] = i;

		if (heapMode)
		{
			siftUp(i);
		}
		else if (size > smallThreshold)
		{
			heapMode = true;
			heapify();
		}
	}

	public final void edit(int taskId, int newPriority)
	{
		int i = pos[taskId];
		if (i == 0)
		{
			return;
		}

		key[i] = packKey(newPriority, taskId);

		if (heapMode)
		{
			int parent = i >>> 1;
			if (i > 1 && key[i] > key[parent])
			{
				siftUp(i);
			}
			else
			{
				siftDown(i);
			}
		}
	}

	public final void rmv(int taskId)
	{
		int i = pos[taskId];
		if (i == 0)
		{
			return;
		}

		pos[taskId] = 0;

		if (i == size)
		{
			size--;
			return;
		}
		long lk = key[size];
		long lp = payload[size];
		int movedTask = (int) lp;

		size--;
		key[i] = lk;
		payload[i] = lp;
		pos[movedTask] = i;

		if (heapMode)
		{
			int parent = i >>> 1;
			if (i > 1 && key[i] > key[parent])
			{
				siftUp(i);
			}
			else
			{
				siftDown(i);
			}
		}
	}

	public final int execTop()
	{
		if (size == 0)
		{
			return -1;
		}

		if (heapMode)
		{
			long rootPayload = payload[1];
			int topUser = (int) (rootPayload >>> 32);
			int topTask = (int) rootPayload;
			pos[topTask] = 0;

			if (size == 1)
			{
				size = 0;
				return topUser;
			}

			long lk = key[size];
			long lp = payload[size];
			int movedTask = (int) lp;
			size--;

			key[1] = lk;
			payload[1] = lp;
			pos[movedTask] = 1;

			siftDown(1);
			return topUser;
		}
		else
		{
			int best = 1;
			long bestKey = key[1];
			for (int i = 2; i <= size; i++)
			{
				long ki = key[i];
				if (ki > bestKey)
				{
					bestKey = ki;
					best = i;
				}
			}

			long pl = payload[best];
			int topUser = (int) (pl >>> 32);
			int topTask = (int) pl;
			pos[topTask] = 0;

			if (best != size)
			{
				long lk = key[size];
				long lp = payload[size];
				int movedTask = (int) lp;
				key[best] = lk;
				payload[best] = lp;
				pos[movedTask] = best;
			}
			size--;
			return topUser;
		}
	}

	private void heapify()
	{
		for (int j = size >>> 1; j >= 1; j--)
		{
			siftDown(j);
		}
	}

	private void siftUp(int i)
	{
		long k = key[i];
		long pl = payload[i];
		int t = (int) pl;

		while (i > 1)
		{
			int p = i >>> 1;
			if (key[p] >= k)
			{
				break;
			}

			key[i] = key[p];
			payload[i] = payload[p];
			pos[(int) payload[i]] = i;

			i = p;
		}

		key[i] = k;
		payload[i] = pl;
		pos[t] = i;
	}

	private void siftDown(int i)
	{
		long k = key[i];
		long pl = payload[i];
		int t = (int) pl;

		while (true)
		{
			int left = i << 1;
			if (left > size)
			{
				break;
			}
			int right = left + 1;
			int best = left;
			if (right <= size && key[right] > key[left])
			{
				best = right;
			}
			if (key[best] <= k)
			{
				break;
			}

			key[i] = key[best];
			payload[i] = payload[best];
			pos[(int) payload[i]] = i;

			i = best;
		}

		key[i] = k;
		payload[i] = pl;
		pos[t] = i;
	}

	private static long packKey(int priority, int taskId)
	{
		return (((long) priority) << KEY_SHIFT) | (taskId & TASK_MASK);
	}

	private static long packPayload(int userId, int taskId)
	{
		return (((long) userId) << 32) | (taskId & 0xFFFF_FFFFL);
	}

	private void ensureCapacity(int requiredIndex)
	{
		if (requiredIndex < key.length)
		{
			return;
		}
		int newCap = key.length << 1;
		if (newCap <= requiredIndex)
		{
			newCap = requiredIndex + 1;
		}

		long[] nk = new long[newCap];
		long[] np = new long[newCap];
		System.arraycopy(key, 0, nk, 0, key.length);
		System.arraycopy(payload, 0, np, 0, payload.length);
		key = nk;
		payload = np;
	}

	private static int initialCapacity(int initial, int expectedMaxConcurrentTasks)
	{
		if (expectedMaxConcurrentTasks > 0)
		{
			return Math.max(16, expectedMaxConcurrentTasks + 2);
		}
		int want = Math.max(16, initial + 8);
		int cap = 1;
		while (cap < want)
		{
			cap <<= 1;
		}
		return cap;
	}
}

```  
  
</details>
