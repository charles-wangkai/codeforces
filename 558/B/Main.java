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
		System.out.print(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		Map<Integer, Integer> valueToCount = new HashMap<>();
		Map<Integer, Integer> valueToBeginIndex = new HashMap<>();
		Map<Integer, Integer> valueToEndIndex = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			valueToCount.put(a[i], valueToCount.getOrDefault(a[i], 0) + 1);

			if (!valueToBeginIndex.containsKey(a[i])) {
				valueToBeginIndex.put(a[i], i);
			}

			valueToEndIndex.put(a[i], i);
		}

		int maxCount = 0;
		int beginIndex = -1;
		int endIndex = -1;
		for (int value : valueToCount.keySet()) {
			int count = valueToCount.get(value);

			if (count > maxCount || (count == maxCount
					&& valueToEndIndex.get(value) - valueToBeginIndex.get(value) < endIndex - beginIndex)) {
				maxCount = count;
				beginIndex = valueToBeginIndex.get(value);
				endIndex = valueToEndIndex.get(value);
			}
		}

		return String.format("%d %d", beginIndex + 1, endIndex + 1);
	}
}
