import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long x = sc.nextLong();
		System.out.println(solve(x));

		sc.close();
	}

	static long solve(long x) {
		String xStr = String.valueOf(x);
		StringBuilder result = new StringBuilder();
		for (char ch : xStr.toCharArray()) {
			int digit = ch - '0';
			if ((digit == 9 && result.length() == 0) || digit <= 4) {
				result.append(digit);
			} else {
				result.append(9 - digit);
			}
		}
		return Long.parseLong(result.toString());
	}
}
