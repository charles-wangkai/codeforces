import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int[] p = new int[n];
			for (int i = 0; i < p.length; i++) {
				p[i] = sc.nextInt();
			}

			System.out.println(solve(p));
		}

		sc.close();
	}

	static String solve(int[] p) {
		Map<Integer, Integer> valueToIndex = new HashMap<>();
		for (int i = 0; i < p.length; i++) {
			valueToIndex.put(p[i], i);
		}

		StringBuilder result = new StringBuilder();
		int minIndex = Integer.MAX_VALUE;
		int maxIndex = Integer.MIN_VALUE;
		for (int value = 1; value <= p.length; value++) {
			int index = valueToIndex.get(value);

			minIndex = Math.min(minIndex, index);
			maxIndex = Math.max(maxIndex, index);

			result.append((maxIndex - minIndex + 1 == value) ? 1 : 0);
		}

		return result.toString();
	}
}
