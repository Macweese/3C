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

package challenge.leetcode.medium.pyramidTransitionMatrix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 01:31 Mon 29 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("756. Pyramid Transition Matrix")
class PyramidTransitionMatrixTest
{
	private static final Map<Input, Boolean> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input("BCD",List.of("BCC","CDE","CEA","FFF")),true);
		MAP.put(new Input("AAAA",List.of("AAB","AAC","BCD","BBE","DEF")),false);
		MAP.put(new Input("ABCD",List.of("ABE","BCE","BCF","CDF","EEC","FFA","EAA")),false);
		MAP.put(new Input("AAAA",List.of("AAB","AAC","BCD","BBE","DEF","CBF","FED")),true);
		MAP.put(new Input("ABCD",List.of("ABE","BCE","BCF","CDF","EEC","FFA","CAA")),false);
		MAP.put(new Input("DBCDA",List.of("DBD","BCC","CDD","DAD","DDA","AAC","CCA","BCD")),true);
		MAP.put(new Input("ABCD",List.of("ABC","BCA","CDA","ABD","BCE","CDF","DEA","EFF","AFF")),true);
		MAP.put(new Input("CBDDA",List.of("ACC","ACA","AAB","BCA","BCB","BAC","BAA","CAC","BDA","CAA","CCA","CCC","CCB","DAD","CCD","DAB","ACD","DCA","CAD","CBB","ABB","ABC","ABD","BDB","BBC","BBA","DDA","CDD","CBC","CBA","CDA","DBA","ABA")),true);
		MAP.put(new Input("ABBBBA",List.of("ACA","ACF","ACE","ACD","ABA","ABF","ABE","ABD","FCA","FCF","FCE","FCD","FBA","FBF","FBE","FBD","ECA","ECF","ECE","ECD","EBA","EBF","EBE","EBD","DCA","DCF","DCE","DCD","DBA","DBF","DBE","DBD","CAA","CAF","CAE","CAD","CFA","CFF","CFE","CFD","CEA","CEF","CEE","CED","CDA","CDF","CDE","CDD","BAA","BAF","BAE","BAD","BFA","BFF","BFE","BFD","BEA","BEF","BEE","BED","BDA","BDF","BDE","BDD","CCA","CCF","CCE","CCD","CBA","CBF","CBE","CBD","BCA","BCF","BCE","BCD","BBA","BBF","BBE","BBD","CCC","CCB","CBC","CBB","BCC","BCB","BBC","BBB")),false);
		MAP.put(new Input("ABCDEF",List.of("AAA","AAB","AAC","AAD","AAE","AAF","ABA","ABB","ABC","ABD","ABE","ABF","ACA","ACB","ACC","ACD","ACE","ACF","ADA","ADB","ADC","ADD","ADE","ADF","AEA","AEB","AEC","AED","AEE","AEF","AFA","AFB","AFC","AFD","AFE","AFF","BAA","BAB","BAC","BAD","BAE","BAF","BBA","BBB","BBC","BBD","BBE","BBF","BCA","BCB","BCC","BCD","BCE","BCF","BDA","BDB","BDC","BDD","BDE","BDF","BEA","BEB","BEC","BED","BEE","BEF","BFA","BFB","BFC","BFD","BFE","BFF","CAA","CAB","CAC","CAD","CAE","CAF","CBA","CBB","CBC","CBD","CBE","CBF","CCA","CCB","CCC","CCD","CCE","CCF","DAB","DAC","DAD","DAE","DAF","EAB","EAC","EAD","EAE","EAF","FAB","FAC","FAD","FAE","FAF")),false);
	}

	@Test
	void pyramidTransition()
	{
		for (Map.Entry<Input, Boolean> entry : MAP.entrySet())
		{
			final String bottom = entry.getKey().bottom();
			final List<String> allowed = entry.getKey().allowed();
			final boolean expected = entry.getValue();
			final boolean actual = PyramidTransitionMatrix.pyramidTransition(bottom, allowed);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Bottom", bottom,
				"Allowed", allowed,
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}
record Input(String bottom, List<String> allowed)
{

}