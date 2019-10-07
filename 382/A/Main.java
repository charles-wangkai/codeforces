import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String unused = sc.next();
		System.out.println(solve(s, unused));

		sc.close();
	}

	static String solve(String s, String unused) {
		int delimiterIndex = s.indexOf('|');
		StringBuilder left = new StringBuilder(s.substring(0, delimiterIndex));
		StringBuilder right = new StringBuilder(s.substring(delimiterIndex + 1));

		for (char ch : unused.toCharArray()) {
			if (left.length() <= right.length()) {
				left.append(ch);
			} else {
				right.append(ch);
			}
		}

		return (left.length() == right.length()) ? String.format("%s|%s", left, right) : "Impossible";
	}
}
