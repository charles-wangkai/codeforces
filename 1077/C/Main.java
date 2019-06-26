import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		long total = Arrays.stream(a).asLongStream().sum();

		Map<Long, Integer> valueToCount = new HashMap<>();
		for (int value : a) {
			updateValueToCount(valueToCount, value, 1);
		}

		List<Integer> niceIndices = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			long remainSum = total - a[i];

			if (remainSum % 2 == 0
					&& valueToCount.getOrDefault(remainSum / 2, 0) >= ((a[i] == remainSum / 2) ? 2 : 1)) {
				niceIndices.add(i + 1);
			}
		}

		return String.format("%d\n%s", niceIndices.size(),
				niceIndices.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}

	static void updateValueToCount(Map<Long, Integer> valueToCount, long value, int delta) {
		valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
	}
}
