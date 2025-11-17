# 2353. Design a Food Rating System

<h3 style="color:#E39A2D;">Medium</h3>

[LeetCode 2353](https://leetcode.com/problems/design-a-food-rating-system/)

## Description

Design a food rating system that can do the following:

* **Modify** the rating of a food item listed in the system.
* Return the highest-rated food item for a type of cuisine in the system.

Implement the `FoodRatings` class:

* `FoodRatings(String[] foods, String[] cuisines, int[] ratings)` Initializes the system. The food items are described by `foods`, `cuisines` and `ratings`, all of which have a length of `n`.
  * `foods[i]` is the name of the <code>i<sup>th</sup></code> food,
  * `cuisines[i]` is the type of cuisine of the <code>i<sup>th</sup></code> food, and
  * `ratings[i]` is the initial rating of the <code>i<sup>th</sup></code> food.
* `void changeRating(String food, int newRating)` Changes the rating of the food item with the name `food`.
* `String highestRated(String cuisine)` Returns the name of the food item that has the highest rating for the given type of `cuisine`. If there is a tie, return the item with the **lexicographically smaller** name.

Note that a string `x` is lexicographically smaller than string `y` if `x` comes before `y` in dictionary order, that is, either `x` is a prefix of `y`, or if `i` is the first position such that `x[i] != y[i]`, then `x[i]` comes before `y[i]` in alphabetic order.

<br>

#### Example 1
<div style="margin-left: 40px">
	
<b>Input:</b> <br>  
```
["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
[
    ["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"],
    ["korean", "japanese", "japanese", "greek", "japanese", "korean"],
    [9, 12, 8, 15, 14, 7]],
["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]
```
<b>Output:</b>  `[null, "kimchi", "ramen", null, "sushi", null, "ramen"]`

<b>Explanation:</b> 

<div style="margin-left: 40px">
    
    // Program calls programCalls[]:
    // ["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
    
    // Input:
    // ProgramCalls[0] = "FoodRatings", this initializes the food rating system with the following data:
    [                                                                      // This is the FoodRating
        ["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"],       // This is the FoodRating
        ["korean", "japanese", "japanese", "greek", "japanese", "korean"], // This is the FoodRating
        [9, 12, 8, 15, 14, 7]                                              // This is the FoodRating
    ],

    // Subsequent calls in ProgramCalls[]:
    ["korean"],                                                            // highestRated
    ["japanese"],                                                          // highestRated
    ["sushi", 16],                                                         // changeRating
    ["japanese"],                                                          // highestRated
    ["ramen", 16],                                                         // changeRating
    ["japanese"]                                                           // highestRated

<br>

	FoodRatings foodRatings = new FoodRatings(
        new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
        new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
        new int[]{9, 12, 8, 15, 14, 7}
    );

	foodRatings.highestRated("korean");     // return "kimchi"
                                            // "kimchi" is the highest rated korean food with a rating of 9.
	foodRatings.highestRated("japanese");   // return "ramen"
                                            // "ramen" is the highest rated japanese food with a rating of 14.
	foodRatings.changeRating("sushi", 16);  // "sushi" now has a rating of 16.
	foodRatings.highestRated("japanese");   // return "sushi"
                                            // "sushi" is the highest rated japanese food with a rating of 16.
	foodRatings.changeRating("ramen", 16);  // "ramen" now has a rating of 16.
	foodRatings.highestRated("japanese");   // return "ramen"
</div>
</div>

### Constraints:

* <code>1 &le; n &le; 2 &times; 10<sup>4</sup></code>
* `n == foods.length == cuisines.length == ratings.length`
* <code>1 &le; foods[i].length, cuisines[i].length &le; 10</code>
* `foods[i], cuisines[i]` consist of lowercase English letters.
* <code>1 &le; ratings[i] &le; 10<sup>8</sup></code>
* All the strings in `foods` are **distinct**.
* `food` will be the name of a food item in the system across all calls to `changeRating`.
* `cuisine` will be a type of cuisine of **at least one** food item in the system across all calls to `highestRated`.
* At most <code>2 &times; 10<sup>4</sup></code> calls in total will be made to `changeRating` and `highestRated`.

<br>

## Solution



### Intuition

We need to support two operations efficiently:

1. Update a food’s rating
2. Query the highest-rated food in a cuisine  
   *This needs to break ties by lexicographical ordering*  
 
A natural fit is to keep, for each cuisine, a priority/tree structure ordered by (rating descending, name ascending).  
As well as a map from food to origin and a map for food to rating:  
* $ f_o \mapsto \text{origin} $ 
* $ f_r \mapsto \text{rating} $  

To avoid expensive deletes in heaps, we use lazy deletion: push new entries; when querying, discard stale tops. Note that this, however, is at the cost of memory.


### Approach

* Maintain  
  * Lookup ability `origin` → `food`
  * Lookup ability `food` → `rating`
  * For each origin, its own priority queue/max heap/red-black tree, that provides a top rating.
<br><br>
* `ChangeRating(food, rating)`:  
   Poll `foods`, then push `food:rating` into the respective `origin` heap.
<br><br>
* `highestRating(origin)`:  
  Peek the heap for the respective `origin`, if the top entry matches the current top rating in `foods`, then return it.  
  Otherwise, pop and continue (lazy removal of stale entries).



### Complexity analysis

$$
\begin{flalign}&
n \stackrel{\text{def}}{=}
\text{number of food items in total}
&\end{flalign}
$$

$$
\begin{flalign} &
k \stackrel{\text{def}}{=}
\text{number of food items for an origin}
& \end{flalign}
$$

<h4>Time Complexity</h4>

* Time complexity: $ O(\log{k}) $  
  Each `.add()` or `.remove()` on an `origin` heap is $ O(\log{k}) $ where $ k $ is the number of items in that origin category of foods.  
  Across all origin categories, each operation is $ O(\log{n}) $ in the worst case.

<h4>Space Complexity</h4>

* Space complexity: $ O(n) $  
  Heaps store current and stale entries, thus worst case the space is $ O(n) $. 

### Code

```java
class FoodRatings
{
	private Map<String, Integer> foodRating;
	private Map<String, String> origins;
	private Map<String, TreeSet<Food>> foodsFromOrigin;

	private static class Food implements Comparable<Food>
	{
		String name;
		int rating;

		Food(String name, int rating)
		{
			this.name = name;
			this.rating = rating;
		}

		@Override
		public int compareTo(Food other)
		{
			if (this.rating != other.rating)
			{
				return Integer.compare(other.rating, this.rating);
			}
			return this.name.compareTo(other.name);
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
			{
				return true;
			}
			if (obj == null || getClass() != obj.getClass())
			{
				return false;
			}
			Food food = (Food) obj;
			return Objects.equals(name, food.name);
		}

		@Override
		public int hashCode()
		{
			return Objects.hash(name);
		}
	}

	public FoodRatings(String[] foodList, String[] orignList, int[] ratingList)
	{
		if (foodList.length != orignList.length || foodList.length != ratingList.length)
		{
			throw new IllegalArgumentException("All input arguments must be equal length.");
		}

		this.foodRating = new HashMap<>(foodList.length);
		this.origins = new HashMap<>(foodList.length);
		this.foodsFromOrigin = new HashMap<>();

		for (int i = 0; i < foodList.length; i++)
		{
			String food = foodList[i];
			String origin = orignList[i];
			int rating = ratingList[i];

			foodRating.put(food, rating);
			origins.put(food, origin);

			foodsFromOrigin.computeIfAbsent(origin, k -> new TreeSet<>())
				.add(new Food(food, rating));
		}
	}

	public void changeRating(String food, int newRating)
	{
		Integer oldRating = foodRating.get(food);
		if (oldRating == null)
		{
			return;
		}

		String origin = origins.get(food);
		TreeSet<Food> foods = foodsFromOrigin.get(origin);

		foods.remove(new Food(food, oldRating));
		foods.add(new Food(food, newRating));

		foodRating.put(food, newRating);
	}

	public String highestRated(String origin)
	{
		TreeSet<Food> foods = foodsFromOrigin.get(origin);
		if (foods == null || foods.isEmpty())
		{
			return "";
		}

		Food topFood = foods.getFirst();
		while (topFood != null && !foodRating.get(topFood.name).equals(topFood.rating))
		{
			foods.remove(topFood);
			if (foods.isEmpty())
			{
				return "";
			}
			topFood = foods.getFirst();
		}

		return foods.first().name;
	}
}
```

![img.png](designFoodRatingSystemAC.png)

---

<br>

#### Tags

`array`
`hash table`
`string`
`design`
`heap`
`priority queue`
`tree`
`ordered set`
`weekly contest 303`

---

#### Hints

<details>
  <summary>Hint 1</summary>

The key to solving this problem is to properly store the data using the right data structures.

</details>

<details>
  <summary>Hint 2</summary>

Firstly, a hash table is needed to efficiently map each food item to its cuisine and current rating.

</details>


<details>
  <summary>Hint 3</summary>

In addition, another hash table is needed to map cuisines to foods within each cuisine stored in an ordered set according to their ratings.

</details>

<br>

#### Similar

**LeetCode** (website)

* [2349 Design a Number Container System](https://leetcode.com/problems/design-a-number-container-system/)
* [2456 Most Popular Video Creator](https://leetcode.com/problems/most-popular-video-creator/)

**Local** (repository)

* [2349 Design a Number Container System](../../medium/designANumberContainerSystem)
* [2456 Most Popular Video Creator](../../medium/mostPopularVideoCreator)

---

**POTD** `2025-09-17, Wed
 17 September 2025`

[comment]: #
[comment]: #
[comment]: #

<br>

**Notes**  



