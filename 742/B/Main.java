import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, x));

		sc.close();
	}

	static long solve(int[] a, int x) {
		Map<Integer, Integer> valueToCount = new HashMap<>();
		for (int value : a) {
			valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
		}

		long result = 0;
		for (int value : valueToCount.keySet()) {
			int count = valueToCount.get(value);
			int other = value ^ x;

			if (other == value) {
				result += count * (count - 1L);
			} else {
				result += (long) count * valueToCount.getOrDefault(other, 0);
			}
		}
		result /= 2;

		return result;
	}
}
