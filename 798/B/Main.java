import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] s = new String[n];
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.next();
		}
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String[] s) {
		if (Arrays.stream(s).anyMatch(str -> !(s[0] + s[0]).contains(str))) {
			return -1;
		}

		int result = Integer.MAX_VALUE;
		String target = s[0];
		for (int i = 0; i < s[0].length(); i++) {
			result = Math.min(result, computeTotalMoveNum(s, target));

			target = move(target);
		}

		return result;
	}

	static int computeTotalMoveNum(String[] s, String target) {
		return Arrays.stream(s).mapToInt(str -> computeMoveNum(str, target)).sum();
	}

	static String move(String str) {
		return String.format("%s%c", str.substring(1), str.charAt(0));
	}

	static int computeMoveNum(String str, String target) {
		int result = 0;
		while (!str.equals(target)) {
			str = move(str);

			result++;
		}

		return result;
	}
}
