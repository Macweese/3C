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

package challenge.leetcode.medium.designAFoodRatingSystem;

import data.lexicography.words.InMemoryWordSource;
import data.lexicography.words.WordProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
@DisplayName("2353. Design a Food Rating System")
class DesignAFoodRatingSystemTest
{
	private static String[] foods;
	private static String[] origins;
	private static int[] ratings;

	private static final WordProvider foodProvider = WordProvider.builder()
		.addSource(new InMemoryWordSource("adobo","ajiaco","aligot","amok trey","arepa","arancini","asado","bacalhau","banh mi","bibimbap","biryani","borscht","bulgogi","burrito","cachupa","carbonara","cazuela","ceviche","chiles en nogada","chivito","chow mein","couscous","cracked conch","croissant","currywurst","dim sum","dolmades","dumplings","empanadas","enchiladas","falafel","fajitas","feijoada","fish and chips","fondue","fufu","gadogado","galbi","goulash","gumbo","gyro","hakarl","hamburger","hot dog","hummus","jerk chicken","jollof rice","kebab","kibbeh","kimchi","koshary","kottbullar","kunafah","lasagna","lomi salmon","lomo saltado","macaroni and cheese","machboos","mapo tofu","moussaka","muamba de galinha","nasi goreng","nasi lemak","pad thai","paella","peking duck","pelmeni","pho","pierogi","pizza","plov","poutine","puri","ramen","rendang","ropa vieja","rosti","samosa","satay","sauerbraten","shakshouka","shepherds pie","soto ayam","souvlaki","spanakopita","steak frites","stroopwafels","sushi","tabbouleh","tacos","tagine","tamales","tempura","thieboudienne","tikka masala","tonkatsu","tortilla espanola","tzatziki","ugali","varenyky","wiener schnitzel","zurek","aloo gobi","bacalaitos","borscht","causa rellena","cevapcici","chilaquiles","chili con carne","chowder","coq au vin","cullen skink","doro wat","eggplant parmigiana","escargots","fasolada","fish pie","french onion soup","gallo pinto","gnocchi","goulash","haggis","hainanese chicken rice","huevos rancheros","irish stew","jambalaya","jollof rice","kaldereta","katsudon","khachapuri","khoresh fesenjan","kofteh tabrizi","laban immo","lomo saltado","maqluba","mofongo","mofonguitos","moo goo gai pan","moussaka","nachos","nasi uduk","nihari","okroshka","pabellon criollo","pancit","paprikash","pastitsio","patatas bravas","peking duck","penne alla vodka","phat kaphrao","picadillo","pide","plov","pork adobo","pozole","pupusas","qabili palau","quesadilla","raclette","ragout","ratatouille","risotto","riz gras","rouladen","salade nicoise","salmon teriyaki","sancocho","shish kebab","shakshouka","shredded chicken nachos","som tum","souffla","spaghetti carbonara","spaghetti bolognese","bolognese","spaghetti bolognese","kidney","steak","steak pie","pie","stifado","sukiyaki","taboulleh","tacos","pastor","thieboudienne","tzatziki","udon","varenyky","vindaloo","yaki udon","yakitori","ziti","zuppa","toscana","acaraje","adobo","borscht","chili","churrasco","couscous","falafel","feijoada","fufu","goulash","gumbo","jambalaya","jerk chicken","jollof rice","kebab","koshary","laksa","moussaka","nasi","goreng","pad thai","paella","pho","duck","ramen","rendang","vieja","ropa","samosa","satay","shawarma","shakshouka","spaghetti","sushi","tacos","tagine","tempura","tom yum","waffles","bolognese","croquette","gyoza","empanada","fideua","gnocchi","malfouf","mofongo","nasi","lemak","pao","queijo","pierogi","poutine","pupusa","ravioli","risotto","schnitzel","souvlaki","spatzle","tarte","tatin","tiramisu","varenyky","wiener","schnitzel","zaru soba","zurek"))
		.build();

	private static final WordProvider originProvider = WordProvider.builder()
		.addSource(new InMemoryWordSource("albania","algeria","andorra","angola","argentina","armenia","australia","austria","bahamas","bahrain","barbados","belarus","belgium","belize","benin","bhutan","bolivia","botswana","brazil","brunei","bulgaria","burundi","cambodia","cameroon","canada","chad","chile","china","colombia","comoros","congo","croatia","cuba","cyprus","czechia","denmark","djibouti","dominica","ecuador","egypt","england","eritrea","estonia","eswatini","ethiopia","fiji","finland","france","gabon","gambia","georgia","germany","ghana","greece","grenada","guatemala","guinea","guyana","haiti","holy see","honduras","hungary","iceland","india","indonesia","iran","iraq","ireland","israel","italy","jamaica","japan","jordan","kenya","kiribati","kuwait","laos","latvia","lebanon","lesotho","liberia","libya","lithuania","malawi","malaysia","maldives","mali","malta","mauritius","mexico","moldova","monaco","mongolia","morocco","myanmar","namibia","nauru","nepal","nicaragua","niger","nigeria","norway","oman","pakistan","palau","panama","paraguay","peru","poland","portugal","qatar","romania","russia","rwanda","samoa","senegal","serbia","singapore","scotland","slovakia","slovenia","somalia","spain","sri lanka","sudan","suriname","sweden","syria","tanzania","thailand","togo","tonga","tunisia","turkey","tuvalu","uganda","united states","united kingdom","ukraine","uruguay","vanuatu","wales","venezuela","vietnam","yemen","zambia","zimbabwe"))
		.build();

	private static FoodRatingsVerified expectedFoodRating;
	private static FoodRatings actualFoodRating;

	private void generateTest()
	{
		Random random = new Random();
		int size = random.nextInt(2 * 10_000) + 1;
		foods = new String[size];
		for (int i = 0; i < size; ++i)
		{
			foods[i] = foodProvider.query()
				.lengthBetween(1, 10)
				.random()
				.get();
		}

		origins = new String[size];
		for (int i = 0; i < size; ++i)
		{
			origins[i] = originProvider.query()
				.lengthBetween(1, 10)
				.random()
				.get();
		}

		ratings = new int[size];
		for (int i = 0; i < ratings.length; ++i)
		{
			ratings[i] = random.nextInt(100_000_000) + 1;
		}

		expectedFoodRating = new FoodRatingsVerified(foods, origins, ratings);
		actualFoodRating = new FoodRatings(foods, origins, ratings);
	}

	@Test
	void testFoodRatingSystem()
	{
		Random r = new Random();
		final int testSize = r.nextInt(100) + 1;
		for (int testCount = 0; testCount < testSize; ++testCount)
		{
			generateTest();

			for (int i = 0; i < r.nextInt(0, 20_000); i++)
			{
				if ((i & 1) == 0)
				{
					String food = foods[r.nextInt(foods.length)];
					int newRating = r.nextInt(100_000_000) + 1;
					actualFoodRating.changeRating(food, newRating);
					expectedFoodRating.changeRating(food, newRating);
				}
				else
				{
					String origin = origins[r.nextInt(origins.length)];
					String expected = expectedFoodRating.highestRated(origin);
					String actual = actualFoodRating.highestRated(origin);
					String message = String.format("Test failed for case:"
							+ "%n%10s : %s"
							+ "%n%10s : %s"
							+ "%n%10s : %s"
							+ "%n%10s : %s"
							+ "%n%10s",
						"Expected", expectedFoodRating,
						"Actual", actualFoodRating,
						"Expected food", expected,
						"Actual food", actual,
						"");
					assertEquals(expected, actual, message);
				}
			}
		}
	}
}

// This is used to validate inputs / tests
// In other words, this is guaranteed to provide the correct (expected) answer
class FoodRatingsVerified
{
	private final Map<String, String> foodCuisine = new HashMap<>();
	private final Map<String, Integer> foodRating = new HashMap<>();
	private final Map<String, PriorityQueue<Node>> cuisineHeap = new HashMap<>();

	private static class Node
	{
		int rating;
		String food;

		Node(int r, String f)
		{
			rating = r;
			food = f;
		}
	}

	public FoodRatingsVerified(String[] foods, String[] cuisines, int[] ratings)
	{
		int n = foods.length;
		for (int i = 0; i < n; i++)
		{
			String f = foods[i];
			String c = cuisines[i];
			int r = ratings[i];
			foodCuisine.put(f, c);
			foodRating.put(f, r);
			cuisineHeap.computeIfAbsent(c, k -> new PriorityQueue<>(
				(a, b) -> a.rating == b.rating ? a.food.compareTo(b.food) : Integer.compare(b.rating, a.rating)
			)).add(new Node(r, f));
		}
	}

	public void changeRating(String food, int newRating)
	{
		String c = foodCuisine.get(food);
		foodRating.put(food, newRating);
		cuisineHeap.get(c).add(new Node(newRating, food));
	}

	public String highestRated(String cuisine)
	{
		PriorityQueue<Node> pq = cuisineHeap.get(cuisine);
		while (!pq.isEmpty())
		{
			Node top = pq.peek();
			if (foodRating.get(top.food) == top.rating)
			{
				return top.food;
			}
			pq.poll();
		}
		return "";
	}
}