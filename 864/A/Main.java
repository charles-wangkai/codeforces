import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

	static String solve(int[] a) {
		Map<Integer, Integer> numberToCount = new HashMap<>();
		for (int number : a) {
			numberToCount.put(number, numberToCount.getOrDefault(number, 0) + 1);
		}

		if (numberToCount.size() == 2 && numberToCount.values().iterator().next() * 2 == a.length) {
			return String.format("YES\n%s",
					String.join(" ", numberToCount.keySet().stream().map(String::valueOf).toArray(String[]::new)));
		} else {
			return "NO";
		}
	}
}
