import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextInt();
		}
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(int[] s) {
		Map<Integer, Integer> valueToCount = new HashMap<>();
		for (int value : s) {
			valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
		}

		int oneCount = (int) valueToCount.values().stream().filter(count -> count == 1).count();
		boolean hasAtLeastThree = valueToCount.values().stream().anyMatch(count -> count >= 3);

		if (oneCount % 2 != 0 && !hasAtLeastThree) {
			return "NO";
		}

		char[] assignments = new char[s.length];
		int oneToACount = 0;
		boolean atLeastThreeToA = false;
		for (int i = 0; i < assignments.length; i++) {
			int count = valueToCount.get(s[i]);

			if ((count == 1 && (oneToACount + 1) * 2 <= oneCount)
					|| (count >= 3 && oneCount % 2 != 0 && !atLeastThreeToA)) {
				assignments[i] = 'A';

				if (count == 1) {
					oneToACount++;
				} else {
					atLeastThreeToA = true;
				}
			} else {
				assignments[i] = 'B';
			}
		}

		return String.format("YES\n%s", new String(assignments));
	}
}
