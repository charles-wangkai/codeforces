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
		System.out.print(solve(a, k));

		sc.close();
	}

	static String solve(int[] a, int k) {
		Map<Integer, Integer> ratingToIndex = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			ratingToIndex.put(a[i], i + 1);
		}

		if (k > ratingToIndex.size()) {
			return "NO";
		} else {
			return String.format("YES\n%s", String.join(" ",
					ratingToIndex.values().stream().limit(k).map(String::valueOf).toArray(String[]::new)));
		}
	}
}
