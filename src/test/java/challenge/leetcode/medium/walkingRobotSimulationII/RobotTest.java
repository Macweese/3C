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

package challenge.leetcode.medium.walkingRobotSimulationII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 06:22 Tue 07 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2069. Walking Robot Simulation II")
class WalkingRobotSimulationIITest
{
	private static final Map<Input, Output> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(new String[]{"Robot","step","step","getPos","getDir","step","step","step","getPos","getDir"},new int[][]{{6,3},{2},{2},{},{},{2},{1},{4},{},{}}),new Output(new Object[]{null,null,null,new int[]{4,0},"East",null,null,null,new int[]{1,2},"West"}));
		MAP.put(new Input(new String[]{"Robot","step","getPos","getDir","step","step","getPos","getDir","step","step","getPos","getDir"},new int[][]{{10,10},{5},{},{},{20},{30},{},{},{100},{2},{},{}}),new Output(new Object[]{null,null,new int[]{5,0},"East",null,null,new int[]{8,9},"West",null,null,new int[]{9,4},"North"}));
		MAP.put(new Input(new String[]{"Robot","getPos","getDir","step","step","step","getPos","getDir","step","step","getPos","getDir","step","getPos","getDir"},new int[][]{{99,99},{},{},{100000},{50000},{25000},{},{},{1},{1},{},{},{999},{},{}}),new Output(new Object[]{null,new int[]{0,0},"East",null,null,null,new int[]{98,70},"North",null,null,new int[]{98,72},"North",null,new int[]{0,7},"South"}));
		MAP.put(new Input(new String[]{"Robot","step","getPos","getDir","step","getPos","getDir","step","getPos","getDir","step","getPos","getDir","step","getPos","getDir","step","getPos","getDir","step"},new int[][]{{2,2},{1},{},{},{1},{},{},{1},{},{},{1},{},{},{1},{},{},{1},{},{},{100000}}),new Output(new Object[]{null,null,new int[]{1,0},"East",null,new int[]{1,1},"North",null,new int[]{0,1},"West",null,new int[]{0,0},"South",null,new int[]{1,0},"East",null,new int[]{1,1},"North",null}));
		MAP.put(new Input(new String[]{"Robot","step","step","step","step","getPos","getDir","step","step","step","step","getPos","getDir","step","step","step","step","getPos","getDir","step","step","step","step","getPos","getDir"},new int[][]{{50,50},{10},{20},{30},{40},{},{},{50},{60},{70},{80},{},{},{90},{100},{110},{120},{},{},{130},{140},{150},{160},{},{}}),new Output(new Object[]{null,null,null,null,null,new int[]{47,49},"West",null,null,null,null,new int[]{0,32},"South",null,null,null,null,new int[]{0,4},"South",null,null,null,null,new int[]{0,12},"South"}));
		MAP.put(new Input(new String[]{"Robot","getPos","getDir","getDir","getPos","getPos","step","step","step","getPos","getDir","step","step","step","step","step","getPos","getDir","step","getPos","getDir","step","step","step","step","getPos"},new int[][]{{9,4},{},{},{},{},{},{72},{19},{7},{},{},{17},{42},{24},{16},{27},{},{},{47},{},{},{5},{2},{31},{34},{}}),new Output(new Object[]{null,new int[]{0,0},"East","East",new int[]{0,0},new int[]{0,0},null,null,null,new int[]{8,2},"North",null,null,null,null,null,new int[]{4,0},"East",null,new int[]{7,0},"East",null,null,null,null,new int[]{6,3}}));
		MAP.put(new Input(new String[]{"Robot","step","getPos","step","getDir","step","getPos","step","getDir","step","getPos","step","getDir","step","getPos","step","getDir","step","getPos","step","getDir","step","getPos","step","getDir","step","getPos","step","getDir","step"},new int[][]{{3,4},{5},{},{10},{},{15},{},{20},{},{25},{},{30},{},{35},{},{40},{},{45},{},{50},{},{55},{},{60},{},{65},{},{70},{},{75}}),new Output(new Object[]{null,null,new int[]{2,3},null,"North",null,new int[]{0,0},null,"South",null,new int[]{2,3},null,"North",null,new int[]{0,0},null,"South",null,new int[]{2,3},null,"North",null,new int[]{0,0},null,"South",null,new int[]{2,3},null,"North",null}));
		MAP.put(new Input(new String[]{"Robot","step","getPos","getDir","step","getPos","getDir","step","getPos","getDir","step","getPos","getDir","step","getPos","getDir","step","getPos","getDir","step","getPos","getDir","step","getPos","getDir","step","getPos","getDir","step","getPos","getDir","step","getPos","getDir","step"},new int[][]{{100,100},{1000},{},{},{2000},{},{},{3000},{},{},{4000},{},{},{5000},{},{},{6000},{},{},{7000},{},{},{8000},{},{},{9000},{},{},{10000},{},{},{11000},{},{},{12000}}),new Output(new Object[]{null,null,new int[]{89,99},"West",null,new int[]{69,99},"West",null,new int[]{60,0},"East",null,new int[]{99,1},"North",null,new int[]{0,48},"South",null,new int[]{12,0},"East",null,new int[]{17,99},"West",null,new int[]{0,36},"South",null,new int[]{45,99},"West",null,new int[]{0,44},"South",null,new int[]{33,99},"West",null}));
		MAP.put(new Input(new String[]{"Robot","getPos","step","getPos","step","getPos","step","getPos","step","getPos","step","getPos","step","getPos","step","getPos","step","getPos","step","getPos","step","getPos","step","getPos","step","getPos","step","getPos","step","getPos","step","getPos","step","getPos","step","getPos","step","getPos","step","getPos"},new int[][]{{16,16},{},{10},{},{10},{},{10},{},{10},{},{10},{},{10},{},{10},{},{10},{},{10},{},{10},{},{10},{},{10},{},{10},{},{10},{},{10},{},{10},{},{10},{},{10},{},{10},{}}),new Output(new Object[]{null,new int[]{0,0},null,new int[]{10,0},null,new int[]{15,5},null,new int[]{15,15},null,new int[]{5,15},null,new int[]{0,10},null,new int[]{0,0},null,new int[]{10,0},null,new int[]{15,5},null,new int[]{15,15},null,new int[]{5,15},null,new int[]{0,10},null,new int[]{0,0},null,new int[]{10,0},null,new int[]{15,5},null,new int[]{15,15},null,new int[]{5,15},null,new int[]{0,10},null,new int[]{0,0},null,new int[]{10,0}}));
	}


	@Test
	void step()
	{
	}

	@Test
	void getPos()
	{
	}

	@Test
	void getDir()
	{
	}

	@Test
	void robotSim()
	{
		for (Map.Entry<Input, Output> entry : MAP.entrySet())
		{
			final String[] args = entry.getKey().args();
			final int[][] vals = entry.getKey().vals();
			final Object[] expected = entry.getValue().outputs();
			final Object[] actual = WalkingRobotSimulationII.runSimulation(args, vals);

			String message = String.format("Test failed for case:"
					+ "%n%10s :"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s :"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Commands", Arrays.toString(args),
				"Values", Arrays.deepToString(vals),
				"Output",
				"Expected", Arrays.deepToString(expected),
				"Actual", Arrays.deepToString(actual),
				""
			);

			assertArrayEquals(actual, expected, message);
		}
	}

}
record Input(String[] args, int[][] vals)
{

}
record Output(Object[] outputs)
{

}