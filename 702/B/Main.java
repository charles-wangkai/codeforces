import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

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

	static long solve(int[] a) {
		Map<Integer, Integer> valueToCount = new HashMap<>();
		for (int value : a) {
			valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
		}

		long differentValuePairNum = 0;
		for (int i = 1; i <= 30; i++) {
			int sum = 1 << i;

			for (int ai : a) {
				int other = sum - ai;
				if (other != ai) {
					differentValuePairNum += valueToCount.getOrDefault(other, 0);
				}
			}
		}

		return differentValuePairNum / 2
				+ IntStream.rangeClosed(0, 29).mapToLong(x -> C(valueToCount.getOrDefault(1 << x, 0), 2)).sum();
	}

	static long C(int n, int r) {
		if (n < r) {
			return 0;
		}

		long result = 1;
		for (int i = 0; i < r; i++) {
			result = result * (n - i) / (i + 1);
		}

		return result;
	}
}
