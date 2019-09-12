import java.util.ArrayList;
import java.util.Arrays;
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
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print(solve(a, k));

		sc.close();
	}

	static String solve(int[] a, int k) {
		Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (!valueToIndices.containsKey(a[i])) {
				valueToIndices.put(a[i], new ArrayList<>());
			}

			valueToIndices.get(a[i]).add(i);
		}

		if (valueToIndices.values().stream().mapToInt(List::size).max().getAsInt() > k) {
			return "NO";
		}

		int color = 1;
		int[] coloring = new int[a.length];
		for (List<Integer> indices : valueToIndices.values()) {
			for (int index : indices) {
				coloring[index] = color;

				color = color % k + 1;
			}
		}

		return String.format("YES\n%s",
				Arrays.stream(coloring).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}
}
