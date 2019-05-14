import java.util.ArrayList;
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
		int[] sizes = new int[n];
		for (int i = 0; i < sizes.length; i++) {
			sizes[i] = sc.nextInt();
		}
		System.out.print(solve(sizes));

		sc.close();
	}

	static String solve(int[] sizes) {
		int n = sizes.length;

		Map<Integer, Integer> sizeToDay = new HashMap<>();
		for (int i = 0; i < n; i++) {
			sizeToDay.put(sizes[i], i);
		}

		@SuppressWarnings("unchecked")
		List<Integer>[] days = new List[n];
		for (int i = 0; i < days.length; i++) {
			days[i] = new ArrayList<>();
		}

		int index = -1;
		for (int size = n; size >= 1; size--) {
			index = Math.max(index, sizeToDay.get(size));
			days[index].add(size);
		}

		return IntStream.range(0, n)
				.mapToObj(i -> days[i].stream().map(String::valueOf).collect(Collectors.joining(" ")))
				.collect(Collectors.joining("\n"));
	}
}
