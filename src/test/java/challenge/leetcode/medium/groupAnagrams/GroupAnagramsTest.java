/*
 *
 *     Copyright (C) 2026 Macweese <https://www.github.com/Macweese>
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

package challenge.leetcode.medium.groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 05:38 Mon 09 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
class GroupAnagramsTest
{
	private static final Map<String[], List<List<String>>> MAP = new HashMap<>();

	static
	{
		List<InputData> inputData = new ArrayList<>();
		inputData.add(new InputData(new String[]{""}));
		inputData.add(new InputData(new String[]{"a"}));
		inputData.add(new InputData(new String[]{"", ""}));
		inputData.add(new InputData(new String[]{"", "b"}));
		inputData.add(new InputData(new String[]{"ac", "c"}));
		inputData.add(new InputData(new String[]{"tea", "and", "ate", "eat", "den"}));
		inputData.add(new InputData(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
		inputData.add(new InputData(new String[]{"hos", "boo", "nay", "deb", "wow", "bop", "bob", "brr", "hey", "rye", "eve", "elf", "pup", "bum", "iva", "lyx", "yap", "ugh", "hem", "rod", "aha", "nam", "gap", "yea", "doc", "pen", "job", "dis", "max", "oho", "jed", "lye", "ram", "pup", "qua", "ugh", "mir", "nap", "deb", "hog", "let", "gym", "bye", "lon", "aft", "eel", "sol", "jab"}));
		inputData.add(new InputData(new String[]{"nozzle", "punjabi", "waterlogged", "imprison", "crux", "numismatists", "sultans", "rambles", "deprecating", "aware", "outfield", "marlborough", "guardrooms", "roast", "wattage", "shortcuts", "confidential", "reprint", "foxtrot", "dispossession", "floodgate", "unfriendliest", "semimonthlies", "dwellers", "walkways", "wastrels", "dippers", "engrossing", "undertakings", "unforeseen", "oscilloscopes", "pioneers", "geller", "neglects", "cultivates", "mantegna", "elicit", "couriered", "shielded", "shrew", "heartening", "lucks", "teammates", "jewishness", "documentaries", "subliming", "sultan", "redo", "recopy", "flippancy", "rothko", "conductor", "e", "carolingian", "outmanoeuvres", "gewgaw", "saki", "sarah", "snooping", "hakka", "highness", "mewling", "spender", "blockhead", "detonated", "cognac", "congaing", "prissy", "loathes", "bluebell", "involuntary", "aping", "sadly", "jiving", "buffalo", "chided", "instalment", "boon", "ashikaga", "enigmas", "recommenced", "snell", "parsley", "buns", "abracadabra", "forewomen", "persecuted", "carsick", "janitorial", "neonate", "expeditiously", "porterhouse", "bussed", "charm", "tinseled", "pencils", "inherits", "crew", "estimate", "blacktop", "mythologists", "essequibo", "dusky", "fends", "pithily", "positively", "participants", "brew", "tows", "pentathlon", "misdiagnoses", "paraphrase", "telephoning", "engining", "anglo", "duisburg", "shorthorns", "physical", "enquiries", "grudging", "floodlit", "safflower", "asphalts", "representing", "airbrush", "bedevilling", "fulminations", "peacefuller", "hurl", "unequalled", "wiser", "vinson", "paglia", "doggones", "optimist", "rulering", "katmandu", "flutists", "sterling", "oregonians", "boosts", "slaver", "straightedges", "stendhal", "defaulters", "stylize", "chucking", "adulterate", "partaking", "omelettes", "monochrome", "bitched", "foxhound", "tapir", "vocalizing", "manifolding", "northerner", "ineptly", "dunce", "matchbook", "locutions", "docudrama", "sinkers", "paralegal", "sip", "maliced", "lechers", "zippy", "tillman", "penknives", "olympias", "designates", "mossiest", "leanne", "lavishing", "understate", "underwriting", "showered", "belittle", "propounded", "gristly", "toxicity", "trike", "baudelaire", "sheers", "annmarie", "poultices", "therapeutics", "inputs", "bailed", "minutest", "pynchon", "jinx", "jackets", "subsections", "harmonizes", "caesareans", "freshened", "haring", "disruption", "buckle", "per", "pined", "solemnity", "recombined", "chamber", "tangling", "pitiful", "authoritarians", "oort", "ingratiate", "refreshed", "bavarian", "generically", "rescheduled", "typewritten", "level", "magnetism", "socialists", "oligocene", "resentful", "lambast", "counteroffer", "firefight", "phil", "attenuates", "teary", "demarcated", "moralities", "electrified", "pettiness", "unpacking", "hungary", "heavies", "tenancies", "tirade", "solaria", "scarcity", "prettiest", "carrillo", "yodel", "cantilever", "ridiculously", "tagalog", "schismatics", "ossification", "hezbollah", "downscaling", "calking", "tapped", "girl", "alba", "lavishness", "stepparents", "integrator", "overact", "father", "fobbing", "pb", "require", "toes", "sweats", "prisoners", "mbabane", "hatch", "motleyer", "worlds", "decentralize", "ingrained", "shekels", "directorship", "negotiating", "hiawatha", "busying", "reciprocate", "spinsterhood", "supervened", "scrimmage", "decolonized", "buildups", "sedative", "swats", "despotic", "driblets", "redoubting", "stoic", "xeroxes", "satellited", "exteriors", "deregulates", "lawful", "flunk", "broached", "energetics", "moodily", "popinjays", "shoshone", "misleads", "abduct", "nonevent", "flees", "harry", "cleverness", "manipulative", "shoplifts", "tom", "junk", "poniard"}));

		for (InputData data : inputData)
		{
			MAP.put(data.input, data.result);
		}
	}

	@Test
	void groupAnagrams()
	{
		for (Map.Entry<String[], List<List<String>>> entry : MAP.entrySet())
		{
			final String[] input = entry.getKey();
			final List<List<String>> actual = GroupAnagrams.groupAnagrams(input);
			final List<List<String>> expected = entry.getValue();

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", Arrays.toString(input),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}

class InputData
{
	String[] input;
	List<List<String>> result;

	InputData(String[] input)
	{
		this.input = input;
		this.result = toResult(input);
	}

	/**
	 * FROM LEETCODE
	 *
	 * @param input
	 * @return result
	 */
	private static List<List<String>> toResult(String[] input)
	{
		if (input == null || input.length == 0)
		{
			return Collections.emptyList();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String s : input)
		{
			//char type 0~127 is enough for constraint 0 <= strs[i].length <= 100
			//char array to String is really fast, thanks @legendaryengineer
			//You should use other data type when length of string is longer.
			//E.g. Use byte (-128 to 127), short (-32,768 to 32,767),
			//int. -2,147,483,648 to 2,147,483,647
			char[] frequencyArr = new char[26];
			for (int i = 0; i < s.length(); i++)
			{
				frequencyArr[s.charAt(i) - 'a']++;
			}
			//6 ms use char(0~127) array and new String(frequencyArr) method.
			//17ms when use byte (-128 to 127) array and Arrays.toString(frequencyArr) method
			//29ms when use int(-2,147,483,648 to 2,147,483,647) and Arrays.toString(frequencyArr) method
			String key = new String(frequencyArr);
			List<String> tempList = map.getOrDefault(key, new LinkedList<>());
			tempList.add(s);
			map.put(key, tempList);
		}
		return new LinkedList<>(map.values());
	}
}
