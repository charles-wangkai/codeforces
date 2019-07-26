import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String n = sc.next();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(String n) {
		if (n.length() == 1) {
			return 0;
		}

		int digitSum = computeDigitSum(n);
		int result = 1;
		while (digitSum >= 10) {
			digitSum = computeDigitSum(String.valueOf(digitSum));
			result++;
		}
		return result;
	}

	static int computeDigitSum(String s) {
		return s.chars().map(ch -> ch - '0').sum();
	}
}
