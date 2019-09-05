import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		StringBuilder result = new StringBuilder(s);
		int index = 0;
		for (char ch = 'a'; ch <= 'z'; ch++) {
			while (index < s.length() && s.charAt(index) > ch) {
				index++;
			}

			if (index == s.length()) {
				return "-1";
			}

			result.setCharAt(index, ch);
			index++;
		}

		return result.toString();
	}
}
