import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print(solve(a, k, m));

		sc.close();
	}

	static String solve(int[] a, int k, int m) {
		Map<Integer, List<Integer>> remainderToValues = new HashMap<>();
		for (int value : a) {
			int remainder = value % m;
			if (!remainderToValues.containsKey(remainder)) {
				remainderToValues.put(remainder, new ArrayList<>());
			}

			remainderToValues.get(remainder).add(value);
		}

		List<List<Integer>> valueLists = remainderToValues.values().stream().filter(values -> values.size() >= k)
				.collect(Collectors.toList());

		return valueLists.isEmpty() ? "No"
				: String.format("Yes\n%s",
						valueLists.get(0).stream().map(String::valueOf).limit(k).collect(Collectors.joining(" ")));
	}
}
