import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

	static int solve(int[] a, int k) {
		Map<Integer, Integer> valueToCount = new HashMap<>();
		for (int value : a) {
			valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
		}

		int dishNum = valueToCount.values().stream().mapToInt(count -> divideToCeil(count, k)).max().getAsInt();

		return valueToCount.values().stream().mapToInt(count -> dishNum * k - count).sum();
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
