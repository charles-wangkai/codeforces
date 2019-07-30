import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a));
		}

		sc.close();
	}

	static int solve(int[] a) {
		Map<Integer, Integer> valueToCount = new HashMap<>();
		for (int value : a) {
			valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
		}

		int result = 0;
		int limit = Integer.MAX_VALUE;
		for (int count : valueToCount.values().stream().sorted(Collections.reverseOrder())
				.collect(Collectors.toList())) {
			int chosen = Math.min(limit, count);
			result += chosen;

			limit = Math.max(0, chosen - 1);
		}
		return result;
	}
}
