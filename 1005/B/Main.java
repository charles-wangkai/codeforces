import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String t = sc.next();
		System.out.println(solve(s, t));

		sc.close();
	}

	static int solve(String s, String t) {
		int sameSuffixLength = 0;
		while (sameSuffixLength + 1 <= Math.min(s.length(), t.length())
				&& s.charAt(s.length() - 1 - sameSuffixLength) == t.charAt(t.length() - 1 - sameSuffixLength)) {
			sameSuffixLength++;
		}
		return s.length() + t.length() - 2 * sameSuffixLength;
	}
}
