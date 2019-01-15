import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String s) {
		return find(s, "AB", "BA") || find(s, "BA", "AB");
	}

	static boolean find(String s, String firstTarget, String secondTarget) {
		int index = s.indexOf(firstTarget);
		if (index < 0) {
			return false;
		}

		return s.indexOf(secondTarget, index + firstTarget.length()) >= 0;
	}
}
