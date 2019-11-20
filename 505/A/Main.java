import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		for (int i = 0; i <= s.length(); i++) {
			for (char letter = 'a'; letter <= 'z'; letter++) {
				String inserted = String.format("%s%c%s", s.substring(0, i), letter, s.substring(i));

				if (isPalindrome(inserted)) {
					return inserted;
				}
			}
		}

		return "NA";
	}

	static boolean isPalindrome(String str) {
		return new StringBuilder(str).reverse().toString().equals(str);
	}
}
