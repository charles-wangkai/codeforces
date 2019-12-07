import java.util.Scanner;

public class Main {
	static final char[] ALPHABET = { 'a', 'b', 'c' };

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
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch == '?') {
				for (char letter : ALPHABET) {
					if (!isSame(letter, result, result.length() - 1) && !isSame(letter, s, i + 1)) {
						result.append(letter);

						break;
					}
				}
			} else {
				if (isSame(ch, result, result.length() - 1)) {
					return "-1";
				}

				result.append(ch);
			}
		}

		return result.toString();
	}

	static boolean isSame(char ch, CharSequence str, int index) {
		return index >= 0 && index < str.length() && str.charAt(index) == ch;
	}
}
