import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
		System.out.println(String.join(" ", Arrays.stream(solve(a)).mapToObj(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static int[] solve(int[] a) {
		SortedMap<Integer, Integer> ratingToCount = new TreeMap<>(Collections.reverseOrder());
		for (int rating : a) {
			ratingToCount.put(rating, ratingToCount.getOrDefault(rating, 0) + 1);
		}

		Map<Integer, Integer> ratingToPosition = new HashMap<>();
		int position = 1;
		for (int rating : ratingToCount.keySet()) {
			ratingToPosition.put(rating, position);

			position += ratingToCount.get(rating);
		}

		return Arrays.stream(a).map(ratingToPosition::get).toArray();
	}
}
