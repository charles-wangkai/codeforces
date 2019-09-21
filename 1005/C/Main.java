import java.util.Arrays;
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

	static int solve(int[] a) {
		Map<Integer, Integer> valueToCount = new HashMap<>();
		for (int value : a) {
			valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
		}

		return a.length - (int) Arrays.stream(a).filter(x -> IntStream.rangeClosed(1, 31).anyMatch(i -> {
			int other = (1 << i) - x;

			if (other == x) {
				return valueToCount.get(x) >= 2;
			} else {
				return valueToCount.containsKey(other);
			}
		})).count();
	}
}
