import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		System.out.println(solve(n) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(long n) {
		return isLuckyNumber((int) String.valueOf(n).chars().filter(Main::isLuckyDigit).count());
	}

	static boolean isLuckyNumber(int x) {
		return x > 0 && String.valueOf(x).chars().allMatch(Main::isLuckyDigit);
	}

	static boolean isLuckyDigit(int ch) {
		return ch == '4' || ch == '7';
	}
}
