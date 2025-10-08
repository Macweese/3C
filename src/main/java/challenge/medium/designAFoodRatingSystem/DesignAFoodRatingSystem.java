/*
 *
 *     Copyright (C) 2025 Macweese <https://www.github.com/Macweese>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package challenge.medium.designAFoodRatingSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @author Administrator
 * @Created 17/09/2025, 10:07 Wed 17 September 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 * @Tags
 * @link <a href="">www.leetcode.com/999999999999999999999</a>
 * @Description Description
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>INPUT_INPUT_INPUT</code>
 * 			<br><b>Output:</b> {@code OUTPUT_OUTPUT_OUTPUT}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp;
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>INPUT_INPUT_INPUT</code>
 * 			<br><b>Output:</b> {@code OUTPUT_OUTPUT_OUTPUT}
 * 			<br><b>Explanation:</b>
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>INPUT_INPUT_INPUT</code>
 * 			<br><b>Output:</b> {@code OUTPUT_OUTPUT_OUTPUT}
 * 			<br><b>Explanation:</b>
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li></li>
 * </ul>
 * </p>
 *
 * <br>
 * <hr>
 * @Similar <a href=""/>1000. NAME (Leetcode)</a><br>
 * <br>
 * {@link challenge. 10000. NAME (local)}<br>
 **/
public class DesignAFoodRatingSystem
{
	public static void main(String[] args)
	{
		String[] foods = new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
		String[] origins = new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"};
		int[] ratings = new int[]{9, 12, 8, 15, 14, 7};

		FoodRatings foodRatings = new FoodRatings(foods, origins, ratings);

		System.out.println(foodRatings.highestRated("korean"));

		System.out.println(foodRatings.highestRated("japanese"));

		foodRatings.changeRating("sushi", 16);
		System.out.println(foodRatings.highestRated("japanese"));

		foodRatings.changeRating("ramen", 16);
		System.out.println(foodRatings.highestRated("japanese"));
	}
}

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
