import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, k));

		sc.close();
	}

	static long solve(int[] a, int k) {
		Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (!valueToIndices.containsKey(a[i])) {
				valueToIndices.put(a[i], new ArrayList<>());
			}

			valueToIndices.get(a[i]).add(i);
		}

		long result = 0;
		for (int value1 : valueToIndices.keySet()) {
			if (isValidInt((long) value1 * k)) {
				int value2 = value1 * k;

				if (valueToIndices.containsKey(value2) && isValidInt((long) value2 * k)) {
					int value3 = value2 * k;

					if (valueToIndices.containsKey(value3)) {
						result += computeWayNum(valueToIndices.get(value1), valueToIndices.get(value2),
								valueToIndices.get(value3));
					}
				}
			}
		}

		return result;
	}

	static boolean isValidInt(long x) {
		return x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE;
	}

	static long choose3(int n) {
		return n * (n - 1L) * (n - 2) / 6;
	}

	static long computeWayNum(List<Integer> indices1, List<Integer> indices2, List<Integer> indices3) {
		long[] wayNums2 = computeWayNums(indices2, indices3,
				IntStream.range(0, indices3.size()).mapToLong(i -> 1).toArray());
		long[] wayNums1 = computeWayNums(indices1, indices2, wayNums2);

		return Arrays.stream(wayNums1).sum();
	}

	static long[] computeWayNums(List<Integer> leftIndices, List<Integer> rightIndices, long[] rightWayNums) {
		long[] result = new long[leftIndices.size()];
		int index = rightIndices.size();
		long sum = 0;
		for (int i = result.length - 1; i >= 0; i--) {
			while (index != 0 && rightIndices.get(index - 1) > leftIndices.get(i)) {
				index--;
				sum += rightWayNums[index];
			}

			result[i] = sum;
		}

		return result;
	}
}
