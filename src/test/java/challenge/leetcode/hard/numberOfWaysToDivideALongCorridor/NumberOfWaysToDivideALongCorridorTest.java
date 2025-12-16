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

package challenge.leetcode.hard.numberOfWaysToDivideALongCorridor;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 09:34 Sun 14 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2147. Number of Ways to Divide a Long Corridor")
class NumberOfWaysToDivideALongCorridorTest
{
	private static final Map<String, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put("S",0);
		MAP.put("P",0);
		MAP.put("SSS",4);
		MAP.put("PPPP",0);
		MAP.put("PPSPSP",1);
		MAP.put("SSPPSPS",3);
		MAP.put("PPPSSPPPSSPPP",4);
		MAP.put("SSSPPSPSPPSPSPSPSPS",8);
		MAP.put("PPPPPPSPSPPSPSPSPSPS",0);
		MAP.put("PPSPSPPPSPSPPSPSPSPSPS",0);
		MAP.put("SSSSPPSPSPPSPSPSPSPSPPPSPSPPSPSPSPSPS",200);
		MAP.put("PPSPSPPSPSPSPSPSSPPSPSPPSPSPSPSPSPPSPSPPSPSPSPSPSPPSPSPPSPSPSPSPS",0);
		MAP.put("PPPSPPPSPSSPPSPSSPSSPPPPSSPSSPPSPPPSSSPSSSPSSSSPSSSSSPSSPSPPSSPSSPPSSSPSPPPSSSSSPSSPPPSSPPSSPSSSPPSP",0);
		MAP.put("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP",0);
		MAP.put("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS",1);
		MAP.put("PSPSPPPSSSSPSSPSSPSPPSSSPPSPSPPPSSSPSPPSSSPSSSPPSPPPSPSPPPSPSPPSSPPSSPSPSSPPPPPSPSPSSSPSSSSPPPSPSPPS",663552);
		MAP.put("PPPPPPPSSSSSPPPSSSSPPPSSSSSSPPSPPSPPSPPPSSPPSSPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP",36);
		MAP.put("SSSSSSSSSSSPPSPSPPSPSPSPSPSSSSSSSSSSSSSSSSSSPPSPSPPSPSPSPSPSSSSSSSSSSSSSSSSSSSSSSSPPSPSPPSPSPSPSPSSSSSSSSSSSSSSSSSSSSSSSSPPSPSPPSPSPSPSPSSSSSSSSSSSSSSSSSPPSPSPPSPSPSPSPSSSSSSSSSSSS",0);
	}

	@Test
	void numberOfWays()
	{
		for (Map.Entry<String, Integer> entry : MAP.entrySet())
		{
			final String input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = NumberOfWaysToDivideALongCorridor.numberOfWays(input);

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
