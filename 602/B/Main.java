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

	static int solve(int[] a) {
		Map<Integer, Integer> valueToCount = new HashMap<>();

		int result = -1;
		int beginIndex = 0;
		for (int endIndex = 0; endIndex < a.length; endIndex++) {
			valueToCount.put(a[endIndex], valueToCount.getOrDefault(a[endIndex], 0) + 1);

			while (valueToCount.size() > 2) {
				valueToCount.put(a[beginIndex], valueToCount.get(a[beginIndex]) - 1);
				valueToCount.remove(a[beginIndex], 0);

				beginIndex++;
			}

			result = Math.max(result, endIndex - beginIndex + 1);
		}

		return result;
	}
}
