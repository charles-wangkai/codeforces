import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			sc.nextInt();
			String s = sc.next();

			System.out.println(solve(s));
		}

		sc.close();
	}

	static int solve(String s) {
		int maxDistance = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				maxDistance = Math.max(maxDistance, Math.max(i + 1, s.length() - i));
			}
		}

		return (maxDistance == -1) ? s.length() : (maxDistance * 2);
	}
}
