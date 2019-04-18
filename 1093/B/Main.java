import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			String s = sc.next();

			System.out.println(solve(s));
		}

		sc.close();
	}

	static String solve(String s) {
		if (s.chars().distinct().count() == 1) {
			return "-1";
		}

		for (int i = 1;; i++) {
			if (s.charAt(i) != s.charAt(0)) {
				StringBuilder result = new StringBuilder(s);
				result.setCharAt(i, s.charAt(s.length() - 1));
				result.setCharAt(s.length() - 1, s.charAt(i));

				return result.toString();
			}
		}
	}
}
