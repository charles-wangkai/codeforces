import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int t = sc.nextInt();

			System.out.println(solve(n, s, t));
		}

		sc.close();
	}

	static int solve(int n, int s, int t) {
		return n - Math.min(s, t) + 1;
	}
}
