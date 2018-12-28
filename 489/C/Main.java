import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int s = sc.nextInt();
		System.out.println(solve(m, s));

		sc.close();
	}

	static String solve(int m, int s) {
		if (s == 0) {
			if (m == 1) {
				return "0 0";
			} else {
				return "-1 -1";
			}
		}

		if (m * 9 < s) {
			return "-1 -1";
		}

		return String.format("%s %s", findMin(m, s, false), findMax(m, s));
	}

	static List<Integer> computeDigits(int s) {
		List<Integer> digits = new ArrayList<>();
		while (s != 0) {
			int digit = Math.min(9, s);

			digits.add(digit);
			s -= digit;
		}
		return digits;
	}

	static String findMax(int m, int s) {
		List<Integer> digits = computeDigits(s);

		StringBuilder result = new StringBuilder();
		for (int digit : digits) {
			result.append(digit);
		}
		while (result.length() < m) {
			result.append(0);
		}
		return result.toString();
	}

	static String findMin(int m, int s, boolean allowLeadingZero) {
		List<Integer> digits = computeDigits(s);

		if (allowLeadingZero || digits.size() == m) {
			return new StringBuilder(findMax(m, s)).reverse().toString();
		} else {
			return String.format("1%s", findMin(m - 1, s - 1, true));
		}
	}
}
