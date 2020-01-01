import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; ++i) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		int n = a.length;

		int[] prevIndices = new int[n];
		int[] lengths = new int[n];
		Map<Integer, Integer> valueToLastIndex = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			if (valueToLastIndex.containsKey(a[i] - 1)) {
				prevIndices[i] = valueToLastIndex.get(a[i] - 1);
				lengths[i] = lengths[valueToLastIndex.get(a[i] - 1)] + 1;
			} else {
				prevIndices[i] = -1;
				lengths[i] = 1;
			}

			valueToLastIndex.put(a[i], i);
		}

		int k = Arrays.stream(lengths).max().getAsInt();
		int index = IntStream.range(0, n).filter(i -> lengths[i] == k).findAny().getAsInt();
		List<Integer> positions = new ArrayList<>();
		while (index != -1) {
			positions.add(index + 1);
			index = prevIndices[index];
		}
		Collections.reverse(positions);

		return String.format("%d\n%s", k, positions.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}
