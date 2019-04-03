import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] sticks = new int[4];
		for (int i = 0; i < sticks.length; i++) {
			sticks[i] = sc.nextInt();
		}
		System.out.println(solve(sticks));

		sc.close();
	}

	static String solve(int[] sticks) {
		if (isTriangle(sticks)) {
			return "TRIANGLE";
		} else if (isSegment(sticks)) {
			return "SEGMENT";
		} else {
			return "IMPOSSIBLE";
		}
	}

	static boolean isTriangle(int[] sticks) {
		for (int i = 0; i < sticks.length; i++) {
			for (int j = i + 1; j < sticks.length; j++) {
				for (int k = j + 1; k < sticks.length; k++) {
					if (sticks[i] + sticks[j] > sticks[k] && sticks[j] + sticks[k] > sticks[i]
							&& sticks[k] + sticks[i] > sticks[j]) {
						return true;
					}
				}
			}
		}
		return false;
	}

	static boolean isSegment(int[] sticks) {
		for (int i = 0; i < sticks.length; i++) {
			for (int j = i + 1; j < sticks.length; j++) {
				for (int k = j + 1; k < sticks.length; k++) {
					if (sticks[i] + sticks[j] == sticks[k] || sticks[j] + sticks[k] == sticks[i]
							|| sticks[k] + sticks[i] == sticks[j]) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
