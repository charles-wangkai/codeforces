import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		SortedMap<Integer, Integer> distanceToCount = new TreeMap<>();
		for (int i = 0; i < a.length - 1; i++) {
			increase(distanceToCount, a[i + 1] - a[i]);
		}

		int result = Integer.MAX_VALUE;
		for (int i = 1; i <= a.length - 2; i++) {
			decrease(distanceToCount, a[i] - a[i - 1]);
			decrease(distanceToCount, a[i + 1] - a[i]);
			increase(distanceToCount, a[i + 1] - a[i - 1]);

			result = Math.min(result, distanceToCount.lastKey());

			decrease(distanceToCount, a[i + 1] - a[i - 1]);
			increase(distanceToCount, a[i + 1] - a[i]);
			increase(distanceToCount, a[i] - a[i - 1]);
		}
		return result;
	}

	static void increase(SortedMap<Integer, Integer> distanceToCount, int distance) {
		distanceToCount.put(distance, distanceToCount.getOrDefault(distance, 0) + 1);
	}

	static void decrease(SortedMap<Integer, Integer> distanceToCount, int distance) {
		distanceToCount.put(distance, distanceToCount.get(distance) - 1);

		if (distanceToCount.get(distance) == 0) {
			distanceToCount.remove(distance);
		}
	}
}
