package challenge.leetcode.medium.minimumMovesToEqualArrayElementsII;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII
{
	public static int minMoves2(int[] ints)
	{
		int sum = 0;
		Arrays.sort(ints);
		int target = ints[ints.length / 2];

		for (int i : ints)
		{
			sum += Math.abs(target - i);
		}
		return sum;
	}
}
