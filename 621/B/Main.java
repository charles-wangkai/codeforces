import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		System.out.println(solve(x, y));

		sc.close();
	}

	static int solve(int[] x, int[] y) {
		Map<Integer, Integer> sumToCount = new HashMap<>();
		Map<Integer, Integer> diffToCount = new HashMap<>();

		for (int i = 0; i < x.length; i++) {
			int sum = x[i] + y[i];
			sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);

			int diff = x[i] - y[i];
			diffToCount.put(diff, diffToCount.getOrDefault(diff, 0) + 1);
		}

		return computeAttackNum(sumToCount) + computeAttackNum(diffToCount);
	}

	static int computeAttackNum(Map<Integer, Integer> keyToCount) {
		return keyToCount.values().stream().mapToInt(count -> count * (count - 1) / 2).sum();
	}
}
