import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		Map<Integer, Integer> valueToCount = new HashMap<>();
		for (int value : a) {
			valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
		}

		int maxCount = valueToCount.values().stream().mapToInt(x -> x).max().getAsInt();
		int valueWithMaxCount = valueToCount.keySet().stream().filter(value -> valueToCount.get(value) == maxCount)
				.findAny().get();

		int index = 0;
		while (a[index] != valueWithMaxCount) {
			index++;
		}

		List<String> operations = new ArrayList<>();
		for (int i = index - 1; i >= 0; i--) {
			if (a[i] < valueWithMaxCount) {
				operations.add(String.format("1 %d %d", i + 1, i + 2));
			} else if (a[i] > valueWithMaxCount) {
				operations.add(String.format("2 %d %d", i + 1, i + 2));
			}
		}
		for (int i = index + 1; i < a.length; i++) {
			if (a[i] < valueWithMaxCount) {
				operations.add(String.format("1 %d %d", i + 1, i));
			} else if (a[i] > valueWithMaxCount) {
				operations.add(String.format("2 %d %d", i + 1, i));
			}
		}

		return String.format("%d\n%s", operations.size(), String.join("\n", operations));
	}
}
