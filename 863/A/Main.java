import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		System.out.println(solve(x) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int x) {
		while (true) {
			if (isPalindrome(x)) {
				return true;
			}

			if (x % 10 != 0) {
				return false;
			}

			x /= 10;
		}
	}

	static boolean isPalindrome(int x) {
		return Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString()) == x;
	}
}
