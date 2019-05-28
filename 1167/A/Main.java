import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			sc.nextInt();
			String s = sc.next();

			System.out.println(solve(s) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(String s) {
		int beginIndex = s.indexOf('8');
		return beginIndex >= 0 && s.length() - beginIndex >= 11;
	}
}
