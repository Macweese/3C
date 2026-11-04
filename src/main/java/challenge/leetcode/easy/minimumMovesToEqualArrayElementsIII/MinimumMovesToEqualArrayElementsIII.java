package challenge.leetcode.easy.minimumMovesToEqualArrayElementsIII;

public class MinimumMovesToEqualArrayElementsIII
{
	public static int minMoves(int[] ints)
	{
		int result = 0;
		int max = Integer.MIN_VALUE;
		for (int i : ints)
		{
			max = Math.max(i, max);
		}

		for (int i : ints)
		{
			result += Math.abs(i - max);
		}

		return result;
	}
}
