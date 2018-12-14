import java.util.Scanner;

public class Main {
	static final String TARGET = "hello";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String s) {
		int fromIndex = 0;
		for (int i = 0; i < TARGET.length(); i++) {
			int index = s.indexOf(TARGET.charAt(i), fromIndex);

			if (index < 0) {
				return false;
			}

			fromIndex = index + 1;
		}
		return true;
	}
}
