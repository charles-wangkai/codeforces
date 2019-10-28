import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int d = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a, k, d));
		}

		sc.close();
	}

	static int solve(int[] a, int k, int d) {
		Map<Integer, Integer> showToCount = new HashMap<>();
		for (int i = 0; i < d; i++) {
			updateMap(showToCount, a[i], 1);
		}

		int result = showToCount.size();
		for (int i = d; i < a.length; i++) {
			updateMap(showToCount, a[i], 1);
			updateMap(showToCount, a[i - d], -1);

			result = Math.min(result, showToCount.size());
		}

		return result;
	}

	static void updateMap(Map<Integer, Integer> showToCount, int show, int delta) {
		showToCount.put(show, showToCount.getOrDefault(show, 0) + delta);
		showToCount.remove(show, 0);
	}
}
