# DSA Snippets & Cheatsheets

## Mathematics

#### Square root
Finding the nearest floored integer square root $ x $ of a number $ n $

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
The sum of integers (inclusive) &emsp; $ \lbrack a ... b\rbrack  $ &emsp; as &emsp; $ \sum_{n=a}^{b}n $  

$$$ f\left(a,b\right)=\frac{\left(\max\left(a,b\right)-\min\left(a,b\right)+1\right)\left(a+b\right)}{2} $$$
```java
public long sumRange(long a, long b)
{
	return (Math.max(a, b) - Math.min(a, b) + 1) * (a + b) / 2;
}
```

#### Fibonacci numbers
Finding the $ n^{th} $ number in sequence (Binet's formula)

```java
public int getN_thFib(int n)
{
	return (int) ((Math.pow(Math.sqrt(5) + 1, n) - Math.pow(Math.sqrt(5) - 1, n)) / (Math.pow(2, n) * Math.sqrt(5)));
}
```

### Combinatorics
Combinations of $ n $ elements, given a pool $ r $

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

Permutations of $ n $ elements

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
	pq.offer(new int[] { src, -1, 0 });

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
			mstEdges.add(new int[] { parent, curr, weight });
		}

		isVisited[curr] = true;
		ans += weight;
		for (int[] neighbour : adj.get(curr))
		{
			int neighbourNodeNumber = neighbour[0];
			int weightOfCurrentNeighbour = neighbour[1];
			pq.offer(new int[] { neighbourNodeNumber, curr, weightOfCurrentNeighbour });
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
		adj.get(con[0] - 1).add(new int[] { con[1] - 1, con[2] });

		if (!isDirected)
		{
			adj.get(con[1] - 1).add(new int[] { con[0] - 1, con[2] });
		}
	}
	return adj;
}
```

  
</details>


<br><hr><br>

## Algorithms

### Data structures iteration

| Algorithm                   | Time                        | Space               | Modifies data |
|-----------------------------|-----------------------------|---------------------|---------------|
| BruteForce                  | $ n^{\text{loop-nesting}} $ | $ \text{constant} $ | No            |
| Sorting                     | $ n \times \log(n) $        | $ \log(n) $         | Yes           |
| Binary Search               | $ n \times \log(n) $        | $ \text{constant} $ | No            |
| Vector/set/hashmap          | $ n $                       | $ n $               | No            |
| Negative marking            | $ n $                       | $ \text{constant} $ | Yes           |
| Mapping Values with indices | $ n $                       | $ \text{constant} $ | Yes           |
| Tortoise-Hare (Fast-Slow)   | $ n $                       | $ \text{constant} $ | No            |

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
	pq.offer(new int[] { src, 0 });

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
				pq.offer(new int[] { to, dis[to] });
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
		adj.get(con[0] - 1).add(new int[] { con[1] - 1, con[2] });

		if (!isDirected)
		{
			adj.get(con[1] - 1).add(new int[] { con[0] - 1, con[2] });
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
	visited[node]= true;

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
void bubble(int[] array)
{
	// ...
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n - 1; j++)
		{
			if (array[j] > array[j + 1])
			{
				swap(array[j], array[j + 1]);
			}
		}
	}
	// ...
}
```

</details>


<details>
<summary><b>Merge sort</b></summary>

```java
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

| $ \text{A} $ | $ \text{B} $ | $ \lnot \text{A} $ | $ \lnot \text{B} $ | $ \text{A} \land \text{B} $ | $ \text{A}  \lor \text{B} $ | $ \text{A}  \Rightarrow \text{B} $ | $ \text{A} \Leftrightarrow  \text{B} $ |
|--------------|--------------|--------------------|--------------------|-----------------------------|-----------------------------|------------------------------------|----------------------------------------|
| $ 0 $        | $ 0 $        | $ 1 $              | $ 1 $              | $ 0 $                       | $ 0 $                       | $ 1 $                              | $ 1 $                                  |
| $ 0 $        | $ 1 $        | $ 1 $              | $ 0 $              | $ 0 $                       | $ 1 $                       | $ 1 $                              | $ 0 $                                  |
| $ 1 $        | $ 0 $        | $ 0 $              | $ 1 $              | $ 0 $                       | $ 1 $                       | $ 0 $                              | $ 0 $                                  |
| $ 1 $        | $ 1 $        | $ 0 $              | $ 0 $              | $ 1 $                       | $ 1 $                       | $ 1 $                              | $ 1 $                                  |

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