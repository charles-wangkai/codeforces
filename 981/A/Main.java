import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		for (int length = s.length(); length >= 1; length--) {
			for (int beginIndex = 0; beginIndex + length <= s.length(); beginIndex++) {
				if (!isPalindrome(s.substring(beginIndex, beginIndex + length))) {
					return length;
				}
			}
		}

		return 0;
	}

	static boolean isPalindrome(String str) {
		return new StringBuilder(str).reverse().toString().contentEquals(str);
	}
}
