package challenge.leetcode.easy.minimumMovesToEqualArrayElementsIII;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("3736. Minimum Move sto Equal Array Elements III")
class MinimumMovesToEqualArrayElementsIIITest
{
	// CF limit 256MB
	private static final long MEMORY_LIMIT_BYTES = 1 << 28;

	static Stream<Arguments> testCaseProvider()
	{
		return Stream.of(
			arguments(new Input(new int[]{1}),0),
			arguments(new Input(new int[]{2,1,3}),3),
			arguments(new Input(new int[]{4,4,5}),2),
			arguments(new Input(new int[]{1,100}),99),
			arguments(new Input(new int[]{7,7,7,7,7}),0),
			arguments(new Input(new int[]{9,1,9,3,9,5}),18),
			arguments(new Input(new int[]{10,9,8,7,6,5,4,3,2,1}),45),
			arguments(new Input(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40}),780),
			arguments(new Input(new int[]{100,1,99,2,98,3,97,4,96,5,95,6,94,7,93,8,92,9,91,10,90,11,89,12,88,13,87,14,86,15,85,16,84,17,83,18,82,19,81,20,80,21,79,22,78,23,77,24,76,25,75,26,74,27,73,28,72,29,71,30}),2970),
			arguments(new Input(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100}),9801)
		);
	}

	@ParameterizedTest(name = "Case {index}")
	@MethodSource("testCaseProvider")
	@Timeout(value = 3, unit = TimeUnit.SECONDS)
	@DisplayName("Tests")
	void test(Input input, Integer expected)
	{
		// Note:
		// Programmatic approach manually invoking gc halts threads globally (STW pause)
		// leading to strong penalty in time execution; may cause false timeout failure.
		// !!! NOT SUITABLE TO BE RUN IN PARALLEL - SHARED STATE FLAKINESS !!!
		Runtime runtime = Runtime.getRuntime();

		runtime.gc();
		long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

		final int actual = MinimumMovesToEqualArrayElementsIII.minMoves(input.ints());

		long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
		long memoryUsed = memoryAfter - memoryBefore;

		if (memoryUsed > MEMORY_LIMIT_BYTES)
		{
			fail(String.format("Memory Limit Exceeded! Used: %,d bytes, Limit: %,d bytes", memoryUsed, MEMORY_LIMIT_BYTES));
		}

		String message = String.format("Test failed for case:"
				+ "%n%10s"
				+ "%n%10s : %s"
				+ "%n%10s"
				+ "%n%10s : %s"
				+ "%n%10s : %s"
				+ "%n%10s ",
			"Input",
			"Ints", Arrays.toString(input.ints()),
			"Output",
			"Expected", expected,
			"Actual", actual,
			""
		);

		assertEquals(expected, actual, message);
	}
}
record Input(int[] ints)
{

}