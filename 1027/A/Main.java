import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			sc.nextInt();
			String s = sc.next();

			System.out.println(solve(s) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			int distance = Math.abs(s.charAt(i) - s.charAt(j));

			if (distance != 0 && distance != 2) {
				return false;
			}
		}
		return true;
	}
}
