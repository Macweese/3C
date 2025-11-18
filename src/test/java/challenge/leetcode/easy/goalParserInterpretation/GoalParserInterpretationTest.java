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

package challenge.leetcode.easy.goalParserInterpretation;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 21:25 Tue 18 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1678. Goal Parser Interpretation")
class GoalParserInterpretationTest
{
	private static final Map<String, String> MAP = new HashMap<>();

	static
	{
		MAP.put("G","G");
		MAP.put("(al)","al");
		MAP.put("()GG","oGG");
		MAP.put("(al)G()","alGo");
		MAP.put("()G(al)","oGal");
		MAP.put("(al)(al)","alal");
		MAP.put("(al)(al)(al)","alalal");
		MAP.put("()()G(al)(al)","ooGalal");
		MAP.put("(al)()(al)(al)","aloalal");
		MAP.put("()()()G()()GG","oooGooGG");
		MAP.put("GG(al)()()(al)","GGalooal");
		MAP.put("G(al)(al)()(al)","Galaloal");
		MAP.put("()GG(al)GGG(al)","oGGalGGGal");
		MAP.put("()()G(al)(al)G()G","ooGalalGoG");
		MAP.put("(al)(al)(al)(al)()","alalalalo");
		MAP.put("(al)GG()(al)(al)()()G","alGGoalalooG");
		MAP.put("(al)G(al)GGGGG(al)()","alGalGGGGGalo");
		MAP.put("(al)(al)()(al)(al)G(al)()","alaloalalGalo");
		MAP.put("G(al)()G(al)(al)G(al)(al)","GaloGalalGalal");
		MAP.put("G(al)(al)GG(al)()()()(al)","GalalGGaloooal");
		MAP.put("()(al)(al)G()G()(al)()(al)","oalalGoGoaloal");
		MAP.put("GG()(al)G()()G()(al)(al)()","GGoalGooGoalalo");
		MAP.put("(al)(al)G(al)()()()(al)(al)","alalGaloooalal");
		MAP.put("()()()()G()()()()(al)GG(al)","ooooGooooalGGal");
		MAP.put("G(al)GG(al)(al)G(al)(al)G()","GalGGalalGalalGo");
		MAP.put("()(al)G()()(al)(al)(al)()G(al)(al)","oalGooalalaloGalal");
		MAP.put("(al)G()()(al)()()()(al)()G()()GG()","alGooaloooaloGooGGo");
		MAP.put("GGG(al)(al)GGG()()(al)G()GG(al)(al)","GGGalalGGGooalGoGGalal");
		MAP.put("G(al)G()G(al)()()(al)G(al)(al)G(al)(al)","GalGoGalooalGalalGalal");
		MAP.put("()(al)()GG(al)()(al)G(al)()G(al)G(al)(al)","oaloGGaloalGaloGalGalal");
		MAP.put("(al)(al)G()()(al)()G(al)G(al)G(al)()(al)()","alalGooaloGalGalGaloalo");
		MAP.put("(al)()GG(al)()()()(al)()(al)(al)()(al)G(al)","aloGGaloooaloalaloalGal");
		MAP.put("()G(al)G(al)(al)(al)G()(al)()GG(al)()()()()","oGalGalalalGoaloGGaloooo");
		MAP.put("()GG(al)()(al)G(al)GG()G()GG(al)(al)GG(al)","oGGaloalGalGGoGoGGalalGGal");
		MAP.put("GGG()GGGG(al)G(al)(al)(al)GG(al)(al)()(al)","GGGoGGGGalGalalalGGalaloal");
		MAP.put("(al)G()(al)G(al)()G()(al)(al)G(al)G(al)GG()G()","alGoalGaloGoalalGalGalGGoGo");
		MAP.put("(al)()(al)G(al)G()(al)GGGGGG()(al)(al)()(al)()","aloalGalGoalGGGGGGoalaloalo");
		MAP.put("()GG()()()G(al)G(al)(al)(al)G()(al)()()GG()()()","oGGoooGalGalalalGoalooGGooo");
		MAP.put("()(al)(al)(al)G(al)()(al)(al)(al)()G()G(al)G()(al)","oalalalGaloalalaloGoGalGoal");
		MAP.put("()G()()G(al)G(al)()()(al)GG()G(al)G(al)()(al)(al)","oGooGalGalooalGGoGalGaloalal");
		MAP.put("(al)GG(al)(al)G(al)(al)(al)(al)()()()GG()G(al)(al)","alGGalalGalalalaloooGGoGalal");
		MAP.put("G(al)(al)()(al)()()G(al)()()G()()()G()G(al)(al)G()","GalaloalooGalooGoooGoGalalGo");
		MAP.put("()()(al)(al)(al)GG()GGG(al)G(al)()()()(al)GG(al)()","ooalalalGGoGGGalGaloooalGGalo");
		MAP.put("G(al)()(al)()()()G(al)(al)GG()(al)()()G()G(al)()(al)","GaloaloooGalalGGoalooGoGaloal");
		MAP.put("(al)GGG()GG(al)()(al)(al)(al)(al)(al)(al)(al)GGGGG(al)","alGGGoGGaloalalalalalalalGGGGGal");
		MAP.put("G()()G()G()GG()()()(al)G(al)G()()()(al)()()()GG(al)(al)","GooGoGoGGoooalGalGoooaloooGGalal");
		MAP.put("GG()(al)(al)(al)()(al)()()G()GGGG()G()(al)()G()(al)()()","GGoalalaloalooGoGGGGoGoaloGoaloo");
		MAP.put("G(al)G(al)G()G(al)G(al)()G(al)()()(al)()(al)G(al)G(al)()","GalGalGoGalGaloGalooaloalGalGalo");
		MAP.put("G(al)()(al)GG(al)G()GGG(al)G(al)(al)G(al)GG(al)(al)G(al)","GaloalGGalGoGGGalGalalGalGGalalGal");
		MAP.put("(al)G()()(al)()()(al)G(al)(al)G(al)G(al)()()()()G()()()()()","alGooalooalGalalGalGalooooGooooo");
		MAP.put("G()()(al)()()()(al)G(al)GG(al)G(al)(al)()(al)()G()()(al)G()","GooaloooalGalGGalGalaloaloGooalGo");
		MAP.put("()()()()(al)()(al)(al)G()G()GG()GG()()()GG(al)(al)GGGG(al)","ooooaloalalGoGoGGoGGoooGGalalGGGGal");
		MAP.put("()()(al)G(al)(al)GG()G(al)(al)()()(al)(al)(al)()()GGGG()(al)","ooalGalalGGoGalalooalalalooGGGGoal");
		MAP.put("(al)G(al)G()G(al)()()(al)G(al)(al)(al)()()(al)()()G(al)()(al)","alGalGoGalooalGalalalooalooGaloal");
		MAP.put("G()(al)GG(al)()()(al)()G()G()()(al)(al)(al)()(al)G()GG()(al)","GoalGGalooaloGoGooalalaloalGoGGoal");
		MAP.put("(al)(al)()(al)()()(al)()(al)(al)(al)()(al)GG()()(al)(al)(al)()","alaloalooaloalalaloalGGooalalalo");
		MAP.put("()()()GG(al)G()G(al)()()G(al)()GG()G()()(al)(al)()G(al)G()()","oooGGalGoGalooGaloGGoGooalaloGalGoo");
		MAP.put("()(al)(al)GG(al)()(al)()()(al)()G()(al)(al)G(al)G(al)GG()(al)","oalalGGaloalooaloGoalalGalGalGGoal");
		MAP.put("G()G()G(al)G(al)G()G()GG(al)(al)()(al)G(al)(al)G(al)(al)(al)","GoGoGalGalGoGoGGalaloalGalalGalalal");
		MAP.put("()G()GGGGGG()G()G()GGGG(al)()(al)G(al)(al)GGG()(al)()GGGG","oGoGGGGGGoGoGoGGGGaloalGalalGGGoaloGGGG");
		MAP.put("G(al)G(al)GG()(al)()G(al)(al)G(al)(al)G(al)(al)(al)G(al)G(al)","GalGalGGoaloGalalGalalGalalalGalGal");
		MAP.put("(al)(al)()G(al)G()()()(al)(al)()()G(al)G()(al)(al)(al)()()()(al)","alaloGalGoooalalooGalGoalalaloooal");
		MAP.put("()()GG()()()()(al)()()()G(al)GGG()G(al)GGGGGG()G(al)(al)(al)(al)","ooGGooooaloooGalGGGoGalGGGGGGoGalalalal");
		MAP.put("()(al)G(al)GG(al)(al)GGGG(al)()G(al)(al)(al)()(al)(al)()G(al)G(al)","oalGalGGalalGGGGaloGalalaloalaloGalGal");
		MAP.put("(al)G()()G()G(al)()()(al)(al)()()GG(al)(al)(al)(al)()()GGG(al)G(al)","alGooGoGalooalalooGGalalalalooGGGalGal");
		MAP.put("(al)(al)(al)()(al)GG(al)GGGG(al)()()G()GG(al)GG(al)(al)G()G()G(al)","alalaloalGGalGGGGalooGoGGalGGalalGoGoGal");
		MAP.put("(al)GG()GG()(al)GG(al)(al)GG()()(al)G(al)()()(al)()()(al)(al)G(al)G","alGGoGGoalGGalalGGooalGalooalooalalGalG");
		MAP.put("G()G()(al)()()()(al)()()()G(al)GG()(al)(al)G()(al)(al)(al)()(al)G()(al)","GoGoaloooaloooGalGGoalalGoalalaloalGoal");
		MAP.put("(al)(al)(al)GG(al)G(al)()GGG()(al)()()()G(al)()(al)()(al)(al)()(al)(al)","alalalGGalGaloGGGoaloooGaloaloalaloalal");
		MAP.put("(al)G(al)G(al)(al)(al)(al)(al)GGG()()GGG(al)G(al)G(al)()(al)()GGG(al)()","alGalGalalalalalGGGooGGGalGalGaloaloGGGalo");
		MAP.put("()GG()(al)(al)()()()(al)GG()G(al)G(al)(al)()GG(al)()()()(al)()()G(al)(al)","oGGoalaloooalGGoGalGalaloGGaloooalooGalal");
		MAP.put("()()GG()(al)()(al)(al)(al)G()(al)GGG()(al)(al)GG(al)GG()(al)()()G(al)(al)","ooGGoaloalalalGoalGGGoalalGGalGGoalooGalal");
		MAP.put("(al)G()GG()(al)G()()()GGG()()(al)(al)G(al)()()G()(al)(al)(al)()G(al)(al)G()","alGoGGoalGoooGGGooalalGalooGoalalaloGalalGo");
		MAP.put("G()(al)(al)()GG()()G()(al)G()()G()(al)()GGGG()G()G(al)(al)(al)GG(al)()(al)G","GoalaloGGooGoalGooGoaloGGGGoGoGalalalGGaloalG");
		MAP.put("(al)()(al)G(al)G(al)()()G()()(al)()()(al)G()(al)GG(al)(al)(al)()()(al)()GG(al)","aloalGalGalooGooalooalGoalGGalalalooaloGGal");
		MAP.put("()()()()G()GG()GG(al)GGGGGG()G(al)G(al)()(al)GG(al)(al)(al)()G(al)(al)(al)()","ooooGoGGoGGalGGGGGGoGalGaloalGGalalaloGalalalo");
		MAP.put("G(al)()G()()()()G(al)(al)()(al)(al)()G()()()G()GG(al)()GGG(al)(al)()G(al)G(al)","GaloGooooGalaloalaloGoooGoGGaloGGGalaloGalGal");
		MAP.put("G(al)(al)G(al)()(al)()GGGG()G(al)()()(al)()()()()()()G()()(al)(al)()GG()(al)(al)","GalalGaloaloGGGGoGalooalooooooGooalaloGGoalal");
		MAP.put("()G()()(al)()()(al)G()()(al)(al)()()G()(al)G(al)()()G(al)()()()()(al)()GG()(al)()","oGooalooalGooalalooGoalGalooGalooooaloGGoalo");
		MAP.put("()()(al)G()(al)(al)(al)(al)()()G(al)(al)(al)()G()GGG()GGG()()(al)()(al)()()(al)()","ooalGoalalalalooGalalaloGoGGGoGGGooaloalooalo");
		MAP.put("GGGG(al)()(al)()GGG()(al)(al)G(al)()G()(al)(al)()(al)(al)GG()G()(al)()()G(al)G()G","GGGGaloaloGGGoalalGaloGoalaloalalGGoGoalooGalGoG");
		MAP.put("(al)()()(al)(al)G()()G()(al)()(al)G()GG()(al)()(al)GG(al)G(al)G()(al)()()(al)()()()()","alooalalGooGoaloalGoGGoaloalGGalGalGoalooaloooo");
		MAP.put("(al)(al)G()(al)()G(al)(al)()G()(al)GG()G()G(al)()GG()GG(al)G(al)()GGGGG(al)G()(al)()","alalGoaloGalaloGoalGGoGoGaloGGoGGalGaloGGGGGalGoalo");
		MAP.put("()G(al)GG(al)()()()G(al)()(al)(al)(al)GG(al)()()G(al)()()(al)(al)(al)(al)(al)()()(al)GG","oGalGGaloooGaloalalalGGalooGalooalalalalalooalGG");
		MAP.put("()(al)()G()()(al)GGGG(al)(al)()()()GG(al)GG(al)GG()()()(al)GG(al)()(al)GG(al)GG()(al)","oaloGooalGGGGalaloooGGalGGalGGoooalGGaloalGGalGGoal");
		MAP.put("()()G()G()GGGG()(al)(al)(al)(al)(al)(al)()G(al)G()(al)G()()(al)(al)GGG(al)G()()(al)(al)","ooGoGoGGGGoalalalalalaloGalGoalGooalalGGGalGooalal");
		MAP.put("(al)(al)(al)GG(al)(al)G()G(al)()()GG()()G(al)G()()()(al)(al)(al)G()GGG()(al)G(al)()(al)","alalalGGalalGoGalooGGooGalGoooalalalGoGGGoalGaloal");
		MAP.put("(al)(al)(al)()GGG(al)()()()(al)GG()G()(al)(al)()()()(al)()G()()()(al)(al)(al)(al)()G(al)G","alalaloGGGaloooalGGoGoalaloooaloGoooalalalaloGalG");
		MAP.put("()()(al)G(al)(al)()(al)(al)()()GG()G(al)()G(al)()()(al)G()(al)(al)(al)GG()(al)G()GG(al)G","ooalGalaloalalooGGoGaloGalooalGoalalalGGoalGoGGalG");
		MAP.put("(al)(al)()(al)GG(al)G()G()(al)(al)(al)()(al)GGG()GGG(al)()()()(al)()()()()G(al)(al)()(al)","alaloalGGalGoGoalalaloalGGGoGGGaloooalooooGalaloal");
		MAP.put("G()(al)()G()(al)()GG(al)()(al)G(al)()G()GGG(al)(al)G()G(al)()G()G(al)()(al)(al)(al)()(al)","GoaloGoaloGGaloalGaloGoGGGalalGoGaloGoGaloalalaloal");
		MAP.put("(al)()(al)GGGGGG(al)G(al)G(al)()(al)()GGG(al)GG()(al)(al)(al)G(al)G()GGG()()()G(al)G(al)","aloalGGGGGGalGalGaloaloGGGalGGoalalalGalGoGGGoooGalGal");
		MAP.put("(al)()()(al)(al)(al)G()GG(al)(al)()GGG()()()()()G()()()()()GG()()()()(al)()(al)G(al)(al)GG()","alooalalalGoGGalaloGGGoooooGoooooGGooooaloalGalalGGo");
		MAP.put("()()()(al)(al)()()()(al)(al)G(al)(al)GGGGG(al)G()GG(al)(al)GGG()(al)()()(al)G()()()GG()(al)","oooalaloooalalGalalGGGGGalGoGGalalGGGoalooalGoooGGoal");
		MAP.put("()()G()G(al)(al)()(al)G(al)G(al)G(al)()()GG(al)(al)GG(al)(al)()(al)(al)(al)GGGG()()(al)GGG()","ooGoGalaloalGalGalGalooGGalalGGalaloalalalGGGGooalGGGo");
		MAP.put("()(al)(al)(al)(al)()(al)()()()G()(al)G()()()G()G(al)()G(al)()(al)GGGG(al)(al)(al)()(al)()(al)()G","oalalalaloaloooGoalGoooGoGaloGaloalGGGGalalaloaloaloG");
		MAP.put("(al)G(al)(al)(al)()()(al)()()()()GGG()G(al)()(al)()G()()(al)()(al)GG(al)()G()()GG()G(al)()(al)GGG()","alGalalalooalooooGGGoGaloaloGooaloalGGaloGooGGoGaloalGGGo");
		MAP.put("G()()()GGG()()()(al)(al)(al)(al)GG()GGG()GG(al)()()()(al)G()()G()(al)GG(al)(al)(al)G()()(al)(al)(al)","GoooGGGoooalalalalGGoGGGoGGaloooalGooGoalGGalalalGooalalal");
	}

	@Test
	void interpretTest()
	{
		for (Map.Entry<String, String> entry : MAP.entrySet())
		{
			final String input = entry.getKey();
			final String expected = entry.getValue();
			final String actual = GoalParserInterpretation.interpret(input);

			String message = String.format("Test failed for case:"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s",
				"Input", input,
				"Expected", expected,
				"Actual", actual
			);

			assertEquals(expected, actual, message);
		}
	}
}