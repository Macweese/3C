# DSA Snippets & Cheatsheets

## Mathematics

#### Square root

Finding the nearest floored integer square root $x$ of a number $n$

```java
public int sqrt(int n)
{
	long root = x;
	while (root * root > x)
	{
		root = (root + x / root) / 2;
	}
	return (int) root;
}
```

#### Power

```java
static long pow(long base, long exp)
{
	int MOD = 1_000_000_007;
	long ans = 1L;
	boolean isNegativeExponent = exp < 0;
	exp = Math.abs(exp);

	while (exp > 0)
	{
		if ((exp & 1) == 1)
		{
			ans = (ans * base * 1L) % MOD;
		}

		base = (base * base * 1L) % MOD;
		exp >>= 1;
	}

	return isNegativeExponent ? (1L / ans) : ans;
}
```

#### Factorial

```java
static void computeFact()
{
	int MOD = 1_000_000_007;
	fact = new long[100001]; // declare long fact[] elsewhere as global / local variable
	fact[0] = fact[1] = 1;

	for (int i = 2; i <= 100000; i++)
	{
		fact[i] = (i * 1L * fact[i - 1]) % MOD;
	}
}
```

#### Prime numbers

```java
static boolean isPrime(int n)
{
	if (n <= 1)
	{
		return false;
	}

	for (int i = 2; i * i <= n; i++)
	{
		if ((n % i) == 0)
		{
			return false;
		}
	}
	return true;
}
```

```java
static List<Integer> getPrimeList(int min, int max)
{
	boolean[] isPrime = new boolean[max + 1];
	List<Integer> primesList = new ArrayList<>();
	Arrays.fill(isPrime, true);

	for (int i = 2; i <= max; i++)
	{
		if (isPrime[i])
		{
			if (i >= min)
			{
				primesList.add(i);
			}
			for (int j = i * i; j <= max; j += i)
			{
				isPrime[j] = false;
			}
		}
	}

	return primesList;
}
```

#### Sum of range

The sum of integers (inclusive) &emsp; $\lbrack a ... b\rbrack$ &emsp; as &emsp; $\sum_{n=a}^{b}n$

$$ f\left(a,b\right)=\frac{\left(\max\left(a,b\right)-\min\left(a,b\right)+1\right)\left(a+b\right)}{2} $$

```java
public long sumRange(long a, long b)
{
	return (Math.max(a, b) - Math.min(a, b) + 1) * (a + b) / 2;
}
```

#### Fibonacci numbers

Finding the $n^{th}$ number in sequence (Binet's formula)

```java
public int getN_thFib(int n)
{
	return (int) ((Math.pow(Math.sqrt(5) + 1, n) - Math.pow(Math.sqrt(5) - 1, n)) / (Math.pow(2, n) * Math.sqrt(5)));
}
```

### Combinatorics

Combinations of $n$ elements, given a pool $r$

```java
int getCombinations(int n)
{
	// If n = 5
	// Possible combinations = !5
	int combinations = 1;
	for (int i = 1; i <= n; i++)
	{
		combinations *= i;
	}
	return combinations;
}

static long nCr(int n, int r)
{
	int MOD = 1_000_000_007;
	long nr = fact[n]; // define long fact[] elsewhere
	long dr = (fact[n - r] * 1L * fact[r]) % MOD;
	long inv = pow(dr, MOD - 2); // Using Fermat's little theorem: inverse(x) = pow(x, m - 2), given m is prime
	long ans = (nr * 1L * inv) % MOD;
	return ans;
}
```

Permutations of $n$ elements

```java

```

#### LCM Least Common Multiple

```java
static int LCM(int a, int b)
{
	return ((a * b) / GCD(a, b));
}
```

#### GCD Greatest Common Denominator

```java
static int GCD(int a, int b)
{
	return (b == 0) ? (a) : GCD(b, a % b);
}
```

### MST Minimum Spanning Tree

<details>
  <summary>MST Minimum Spanning Tree</summary>

```java
// prims
static List<int[]> getMSTGraph(int nNodes, int[][] graph, boolean isDirected)
{

	List<int[]> mstEdges = new ArrayList<>();
	List<List<int[]>> adj = getAdjWeighted(graph, nNodes, isDirected);
	boolean[] isVisited = new boolean[nNodes];
	int src = 0;
	PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);
	// Store format: [node, parent, weightWithParent]
	pq.offer(new int[]{src, -1, 0});

	int ans = 0;

	while (!pq.isEmpty())
	{
		int[] front = pq.poll();
		int curr = front[0];
		int parent = front[1];
		int weight = front[2];

		if (isVisited[curr])
		{
			continue;
		}

		if (parent != -1)
		{
			mstEdges.add(new int[]{parent, curr, weight});
		}

		isVisited[curr] = true;
		ans += weight;
		for (int[] neighbour : adj.get(curr))
		{
			int neighbourNodeNumber = neighbour[0];
			int weightOfCurrentNeighbour = neighbour[1];
			pq.offer(new int[]{neighbourNodeNumber, curr, weightOfCurrentNeighbour});
		}
	}

	if (mstEdges.size() != nNodes - 1)
	{
		// Graph is disconnected
		return null;
	}

	System.out.println("The Minimum spanning tree of given graph has the following adjacency list:");
	for (var e : mstEdges)
	{
		System.out.println(Arrays.toString(e));
	}

	System.out.println("The sum of all weights in MST of given graph  is " + ans);
	return mstEdges;
}

static List<List<int[]>> getAdjWeighted(int[][] graph, int nNodes, boolean isDirected)
{
	List<List<int[]>> adj = new ArrayList<>();

	for (int i = 0; i < nNodes; i++)
	{
		adj.add(new ArrayList<>());
	}

	for (int[] con : graph)
	{
		adj.get(con[0] - 1).add(new int[]{con[1] - 1, con[2]});

		if (!isDirected)
		{
			adj.get(con[1] - 1).add(new int[]{con[0] - 1, con[2]});
		}
	}
	return adj;
}
```

</details>


<br><hr><br>

## Algorithms

### Data structures iteration

| Algorithm                   | Time                      | Space             | Modifies data |
|-----------------------------|---------------------------|-------------------|---------------|
| BruteForce                  | $n^{\text{loop-nesting}}$ | $\text{constant}$ | No            |
| Sorting                     | $n \times \log(n)$        | $\log(n) $        | Yes           |
| Binary Search               | $n \times \log(n)$        | $\text{constant}$ | No            |
| Vector/set/hashmap          | $n$                       | $n$               | No            |
| Negative marking            | $n$                       | $\text{constant}$ | Yes           |
| Mapping Values with indices | $n$                       | $\text{constant}$ | Yes           |
| Tortoise-Hare (Fast-Slow)   | $n$                       | $\text{constant}$ | No            |

<br>

#### Maximum sub-array sum

<details>
<summary><b>Kadane's Algorithm</b></summary>

```java
int kadane(int[] ints, int n)
{
	int best = 0;
	int sum = 0;
	for (int k = 0; k < n; k++)
	{
		sum = max(ints[k], sum + ints[k]);
		best = max(best, sum);
	}
	return best;
}
```

</details>


<br><br>

### Searching Algorithms

#### Djikstra

<details>
  <summary>Djikstra</summary>

```java
// Use when all edges are positive
static int djikstra(int[][] g, int nNodes, int src, int dest)
{
	List<List<int[]>> adj = getAdjWeighted(g, nNodes, true);
	PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);

	int[] dis = new int[nNodes];
	Arrays.fill(dis, (int) 1e9);
	dis[src] = 0;
	pq.offer(new int[]{src, 0});

	while (!pq.isEmpty())
	{
		int[] top = pq.poll();
		int curr = top[0];
		int d = top[1];
		if (d > dis[curr])
		{
			continue;
		}

		for (int[] edge : adj.get(curr))
		{
			int to = edge[0], w = edge[1];
			if (dis[curr] + w < dis[to])
			{
				dis[to] = dis[curr] + w;
				pq.offer(new int[]{to, dis[to]});
			}
		}
	}

	return dis[dest];
}

static List<List<int[]>> getAdjWeighted(int[][] graph, int nNodes, boolean isDirected)
{
	List<List<int[]>> adj = new ArrayList<>();

	for (int i = 0; i < nNodes; i++)
	{
		adj.add(new ArrayList<>());
	}

	for (int[] con : graph)
	{
		adj.get(con[0] - 1).add(new int[]{con[1] - 1, con[2]});

		if (!isDirected)
		{
			adj.get(con[1] - 1).add(new int[]{con[0] - 1, con[2]});
		}
	}
	return adj;
}

static List<List<Integer>> getAdj(int[][] graph, int nNodes, boolean isDirected)
{
	List<List<Integer>> adj = new ArrayList<>();

	for (int i = 0; i < nNodes; i++)
	{
		adj.add(new ArrayList<>());
	}

	for (int[] con : graph)
	{
		adj.get(con[0] - 1).add(con[1] - 1);

		if (!isDirected)
		{
			adj.get(con[1] - 1).add(con[0] - 1);
		}
	}
	return adj;
}
```

</details>

#### WFI Floyd-Warshall

<details>
  <summary>WFI Floyd Warshall</summary>

```java
static long[][] floydWarshall(int nNodes, int[][] g, boolean isDirected)
{
	int INF = (int) 1e9;

	// When I want minimumDistance(u,v) for each query
	// in O(1) time
	long[][] dis = new long[nNodes][nNodes];
	for (int i = 0; i < nNodes; i++)
	{
		Arrays.fill(dis[i], INF);
		dis[i][i] = 0;
	}

	for (int[] e : g)
	{
		dis[e[0] - 1][e[1] - 1] = Math.min(dis[e[0] - 1][e[1] - 1], e[2]);

		if (!isDirected)
		{
			dis[e[1] - 1][e[0] - 1] = Math.min(dis[e[1] - 1][e[0] - 1], e[2]);
		}
	}

	for (int k = 0; k < nNodes; k++)
	{
		long[] disK = dis[k];
		for (int i = 0; i < nNodes; i++)
		{
			long dik = dis[i][k];
			if (dik == INF)
			{
				continue;
			}

			long[] disI = dis[i];
			for (int j = 0; j < nNodes; j++)
			{
				long alt = dik + disK[j];
				if (alt < disI[j])
				{
					disI[j] = alt;
				}
			}
		}
	}

	return dis;
}
```  

</details>


#### Bellman-Ford

<details>
  <summary>Bellman Ford</summary>

```java
// Use when edges can be negative
static int[] bellmanFord(int n, int[][] edges, int src)
{
	int nNodes = n;
	int[] distances = new int[nNodes];
	Arrays.fill(distances, Integer.MAX_VALUE);
	distances[src] = 0;

	// We will update n-1 times by relaxing 1 edge at a time
	for (int i = 0; i < nNodes - 1; i++)
	{
		for (int[] each : edges)
		{
			relaxEdges(each[0], each[1], each[2], distances);
		}
	}

	// Relaxing edges for one more time
	// i.e. n-th time, if distances[] array changes compared
	if (hasCycles(edges, distances))
	{
		return new int[]{-1};
	}

	// To previous version, there exists a cycle
	return distances;
}

static boolean hasCycles(int[][] edges, int[] distances)
{
	int[] clone = distances.clone();
	for (int[] each : edges)
	{
		relaxEdges(each[0], each[1], each[2], clone);
	}

	for (int i = 0; i < distances.length; i++)
	{
		if (distances[i] != clone[i])
		{
			return true;
		}
	}

	return false;
}

static void relaxEdges(int u, int v, int wt, int[] distances)
{
	if (distances[u] != Integer.MAX_VALUE && distances[u] + wt < distances[v])
	{
		distances[v] = distances[u] + wt;
	}
}
```  

</details>

### DFS Depth-First-Search

<details>
  <summary>DFS Depth First Search</summary>

```java
public void dfs(List<Integer>[] adjList, boolean[] visited, int node)
{
	visited[node] = true;

	// Explore all of node's neighbors
	for (int neighbor : adjList[node])
	{
		if (!visited[neighbor])
		{
			dfs(adjList, visited, neighbor);
		}
	}
}

public int countComponents(int n, int[][] edges)
{
	// DFS solution
	// Array to keep track of visited node
	boolean[] visited = new boolean[n];
	// Array of list to store graph
	List<Integer>[] adjList = new ArrayList[n];

	for (int i = 0; i < n; i++)
	{
		adjList[i] = new ArrayList<Integer>();
	}

	// Create adjacency list / graph
	for (int i = 0; i < edges.length; i++)
	{
		adjList[edges[i][0]].add(edges[i][1]);
		adjList[edges[i][1]].add(edges[i][0]); // ASSUMPTION: it is undirected
	}

	int components = 0;
	for (int i = 0; i < n; i++)
	{
		if (!visited[i])
		{
			components++;
			// Start the DFS
			dfs(adjList, visited, i);
		}
	}

	return components;
}
```  

</details>



<br>

### Sorting Algorithms

* **Comparison Based:**
	* Selection Sort
	* Bubble Sort
	* Insertion Sort
	* Merge Sort
	* Quick Sort
	* Heap Sort
	* Cycle Sort
	* 3-way Merge Sort


* **Non Comparison Based:**
	* Counting Sort
	* Radix Sort
	* Bucket Sort
	* TimSort
	* Comb Sort
	* Pigeonhole Sort


* **Hybrid Sorting Algorithms:**
	* IntroSort
	* Tim Sort


* **Shuffling:**
	* Perfect Shuffle (Faro Shuffle / Weave Shuffle)

<br>


<details>
<summary><b>Bubble sort</b></summary>

```java
import java.util.Arrays;

public class BubbleSort
{

	private static void bubbleSort(int[] nums)
	{
		boolean hasChange = true;
		for (int i = 0, n = nums.length; i < n - 1 && hasChange; ++i)
		{
			hasChange = false;
			for (int j = 0; j < n - i - 1; ++j)
			{
				if (nums[j] > nums[j + 1])
				{
					swap(nums, j, j + 1);
					hasChange = true;
				}
			}
		}
	}

	private static void swap(int[] nums, int i, int j)
	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	public static void main(String[] args)
	{
		int[] nums = {1, 2, 7, 9, 5, 8};
		bubbleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
```

</details>


<details>
<summary><b>Shell sort</b></summary>

```java
import java.util.Arrays;

public class ShellSort
{

	private static int[] shellSort(int[] arr)
	{
		int n = arr.length;

		for (int gap = n / 2; gap > 0; gap /= 2)
		{
			for (int i = gap; i < n; i++)
			{
				int key = arr[i];
				int j = i;
				while (j >= gap && arr[j - gap] > key)
				{
					arr[j] = arr[j - gap];
					j -= gap;
				}
				arr[j] = key;
			}
		}
		return arr;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(shellSort(new int[]{1, 2, 7, 9, 5, 8})));
	}
}
```

</details>


<details>
<summary><b>Selection sort</b></summary>

```java
import java.util.Arrays;

public class SelectionSort
{

	private static void selectionSort(int[] nums)
	{
		for (int i = 0, n = nums.length; i < n - 1; ++i)
		{
			int minIndex = i;
			for (int j = i; j < n; ++j)
			{
				if (nums[j] < nums[minIndex])
				{
					minIndex = j;
				}
			}
			swap(nums, minIndex, i);
		}
	}

	private static void swap(int[] nums, int i, int j)
	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	public static void main(String[] args)
	{
		int[] nums = {1, 2, 7, 9, 5, 8};
		selectionSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
```

</details>


<details>
<summary><b>Quick sort</b></summary>

```java
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; ++i)
		{
			nums[i] = sc.nextInt();
		}
		quickSort(nums, 0, n - 1);
		for (int i = 0; i < n; ++i)
		{
			System.out.print(nums[i] + " ");
		}
	}

	public static void quickSort(int[] nums, int left, int right)
	{
		if (left >= right)
		{
			return;
		}
		int i = left - 1, j = right + 1;
		int x = nums[(left + right) >> 1];
		while (i < j)
		{
			while (nums[++i] < x)
				;
			while (nums[--j] > x)
				;
			if (i < j)
			{
				int t = nums[i];
				nums[i] = nums[j];
				nums[j] = t;
			}
		}
		quickSort(nums, left, j);
		quickSort(nums, j + 1, right);
	}
}
```

</details>



<details>
<summary><b>Merge sort</b></summary>

```java
import java.util.Scanner;

public class Main
{
	private static int[] tmp = new int[100010];

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; ++i)
		{
			nums[i] = sc.nextInt();
		}
		mergeSort(nums, 0, n - 1);
		for (int i = 0; i < n; ++i)
		{
			System.out.printf("%d ", nums[i]);
		}
	}

	public static void mergeSort(int[] nums, int left, int right)
	{
		if (left >= right)
		{
			return;
		}
		int mid = (left + right) >>> 1;
		mergeSort(nums, left, mid);
		mergeSort(nums, mid + 1, right);
		int i = left, j = mid + 1, k = 0;
		while (i <= mid && j <= right)
		{
			if (nums[i] <= nums[j])
			{
				tmp[k++] = nums[i++];
			}
			else
			{
				tmp[k++] = nums[j++];
			}
		}
		while (i <= mid)
		{
			tmp[k++] = nums[i++];
		}
		while (j <= right)
		{
			tmp[k++] = nums[j++];
		}
		for (i = left, j = 0; i <= right; ++i, ++j)
		{
			nums[i] = tmp[j];
		}
	}
}
```

</details>


<details>
<summary><b>Insertion sort</b></summary>

```java
import java.util.Arrays;

public class InsertionSort
{
	private static void insertionSort(int[] nums)
	{
		for (int i = 1, j, n = nums.length; i < n; ++i)
		{
			int num = nums[i];
			for (j = i - 1; j >= 0 && nums[j] > num; --j)
			{
				nums[j + 1] = nums[j];
			}
			nums[j + 1] = num;
		}
	}

	public static void main(String[] args)
	{
		int[] nums = {1, 2, 7, 9, 5, 8};
		insertionSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
```

</details>


<details>
<summary><b>Heap sort</b></summary>

```java
import java.util.Scanner;

public class Main
{
	private static int[] h = new int[100010];
	private static int size;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		for (int i = 1; i <= n; ++i)
		{
			h[i] = sc.nextInt();
		}
		size = n;
		for (int i = n / 2; i > 0; --i)
		{
			down(i);
		}
		while (m-- > 0)
		{
			System.out.print(h[1] + " ");
			h[1] = h[size--];
			down(1);
		}
	}

	public static void down(int u)
	{
		int t = u;
		if (u * 2 <= size && h[u * 2] < h[t])
		{
			t = u * 2;
		}
		if (u * 2 + 1 <= size && h[u * 2 + 1] < h[t])
		{
			t = u * 2 + 1;
		}
		if (t != u)
		{
			swap(t, u);
			down(t);
		}
	}

	public static void up(int u)
	{
		while (u / 2 > 0 && h[u / 2] > h[u])
		{
			swap(u / 2, u);
			u /= 2;
		}
	}

	public static void swap(int i, int j)
	{
		int t = h[i];
		h[i] = h[j];
		h[j] = t;
	}
}
```

</details>


<details>
<summary><b>Counting sort</b></summary>

```java
import java.util.Arrays;

public class CountingSort
{
	public static void countingSort(int[] nums, int min, int max)
	{
		int n = nums.length;
		int k = max - min + 1;
		int[] c = new int[k];
		for (int v : nums)
		{
			c[v - min]++;
		}

		for (int i = 1; i < k; i++)
		{
			c[i] += c[i - 1];
		}

		int[] r = new int[n];
		for (int i = n - 1; i >= 0; i--)
		{
			int v = nums[i];
			int a = c[v - min];
			r[a - 1] = v;
			c[v - min]--;
		}
		System.arraycopy(r, 0, nums, 0, n);
	}

	public static void main(String[] args)
	{

		// test case 1
		int[] nums = {1, 2, 7, 9, 5, 5, 8};
		countingSort(nums, 1, 9);
		System.out.println(Arrays.toString(nums));

		// test case 2
		int[] nums2 = {2, 7, 9, 5, 5, 8};
		countingSort(nums2, 2, 9);
		System.out.println(Arrays.toString(nums2));
	}
}
```

</details>

<br>


<details>
<summary><b>Huang-Langston: Perfect shuffle / Faro shuffle</b></summary>

```java
/**
 * Performs perfect (out-)shuffle,
 * in-place with constant-space in O(n) time,
 * using Huang-Langston algorithm.
 *
 * @param a The array to shuffle
 * @return The shuffled array
 */
public static int[] perfectShuffle(int[] a)
{
	int len = a.length;

	if ((len & 1) == 1)
	{
		throw new IllegalArgumentException("Array length must be even (2n).");
	}

	if (len <= 2)
	{
		return a;
	}

	processSegment(a, 0, len);
	return a;
}

private static void processSegment(int[] a, int start, int length)
{
	while (length > 0)
	{
		int m = length / 2;
		if (m <= 1)
		{
			return;
		}

		int blockSize = 3;
		while (blockSize - 1 <= 2 * m)
		{
			blockSize *= 3;
		}

		blockSize /= 3;
		int size = blockSize - 1;
		int n = size / 2;
		int A = start;
		int r = m - n;

		rotateAdjacentBlocks(a, A, n + r, n);
		cycleLeadersBlock(a, start, size);

		start += size;
		length -= size;
	}
}

private static void cycleLeadersBlock(int[] a, int base, int blockSize)
{
	int mod = blockSize + 1;
	for (int start = 1; start < blockSize; start *= 3)
	{
		int i = start;
		int carry = a[base + i - 1];
		while (true)
		{
			int j = (2 * i) % mod;
			if (j == start)
			{
				a[base + j - 1] = carry;
				break;
			}

			int tmp = a[base + j - 1];
			a[base + j - 1] = carry;
			carry = tmp;
			i = j;
		}
	}
}

private static void rotateAdjacentBlocks(int[] a, int i, int sizeA, int sizeB)
{
	if (sizeA == 0 || sizeB == 0)
	{
		return;
	}

	reverse(a, i, i + sizeA - 1);
	reverse(a, i + sizeA, i + sizeA + sizeB - 1);
	reverse(a, i, i + sizeA + sizeB - 1);
}

private static void reverse(int[] a, int l, int r)
{
	for (; l < r; ++l, --r)
	{
		int t = a[l];
		a[l] = a[r];
		a[r] = t;
	}
}
```

</details>

<br>

### PLACEHOLDER

<br>

### Logic

Truth table

| $\text{A}$ | $\text{B}$ | $\lnot \text{A}$ | $\lnot \text{B}$ | $\text{A} \land \text{B}$ | $\text{A} \lor \text{B}$ | $\text{A} \Rightarrow \text{B}$ | $\text{A} \Leftrightarrow \text{B}$ |
|------------|------------|------------------|------------------|---------------------------|--------------------------|---------------------------------|-------------------------------------|
| $0$        | $0$        | $1$              | $1$              | $0$                       | $0$                      | $1$                             | $1$                                 |
| $0$        | $1$        | $1$              | $0$              | $0$                       | $1$                      | $1$                             | $0$                                 |
| $1$        | $0$        | $0$              | $1$              | $0$                       | $1$                      | $0$                             | $0$                                 |
| $1$        | $1$        | $0$              | $0$              | $1$                       | $1$                      | $1$                             | $1$                                 |

<br>

<hr>

<br>

### Competitive programming skill-set

* Logic building
* Complexity analysis
* Arrays
* Searching algorithms
* Sorting algorithms
* Hashing
* Two-pointer technique
* Sliding-window technique
* Prefix-sum
* Strings, string manipulation
* Recursion
* Matrix/grid
* LinkedList
* Stack
* Queue
* Deque
* Tree
* Heap
* Graph
* Greedy algorithms
* Dynamic programming
* Advanced data structure and algorithms
	* Trie
	* Segment tree
	* Red-Black tree
	* Binary-indexed tree
	* Binary search tree
* Bits, bitwise operators and bit manipulation
* Backtracking
* Divide & Conquer
* Branch & Bound algorithm
* Geometric algorithm
* Randomized algorithm
* Pattern searching

<details>
<summary>Algorithm</summary>



</details>