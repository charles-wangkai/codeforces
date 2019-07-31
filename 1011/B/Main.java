import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(n, a));

		sc.close();
	}

	static int solve(int n, int[] a) {
		Map<Integer, Integer> typeToCount = new HashMap<>();
		for (int type : a) {
			typeToCount.put(type, typeToCount.getOrDefault(type, 0) + 1);
		}

		for (int day = a.length / n;; day--) {
			if (day == 0 || computePeopleNum(typeToCount, day) >= n) {
				return day;
			}
		}
	}

	static int computePeopleNum(Map<Integer, Integer> typeToCount, int day) {
		return typeToCount.values().stream().mapToInt(count -> count / day).sum();
	}
}
