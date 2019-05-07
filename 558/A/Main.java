import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			a[i] = sc.nextInt();
		}
		System.out.println(solve(x, a));

		sc.close();
	}

	static int solve(int[] x, int[] a) {
		Map<Integer, Integer> positionToCount = new HashMap<>();
		List<Integer> positives = new ArrayList<>();
		List<Integer> negatives = new ArrayList<>();
		for (int i = 0; i < x.length; i++) {
			positionToCount.put(x[i], a[i]);

			if (x[i] > 0) {
				positives.add(x[i]);
			} else {
				negatives.add(x[i]);
			}
		}
		Collections.sort(positives);
		Collections.sort(negatives, Collections.reverseOrder());

		int commonSize = Math.min(positives.size(), negatives.size());

		return Math.max(
				computeSum(positionToCount, positives, commonSize + (commonSize == positives.size() ? 0 : 1))
						+ computeSum(positionToCount, negatives, commonSize),
				computeSum(positionToCount, positives, commonSize) + computeSum(positionToCount, negatives,
						commonSize + (commonSize == negatives.size() ? 0 : 1)));
	}

	static int computeSum(Map<Integer, Integer> positionToCount, List<Integer> positions, int limit) {
		return positions.stream().limit(Math.max(0, limit)).mapToInt(position -> positionToCount.get(position)).sum();
	}
}
