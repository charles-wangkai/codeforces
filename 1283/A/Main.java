import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int h = sc.nextInt();
			int m = sc.nextInt();

			System.out.println(solve(h, m));
		}

		sc.close();
	}

	static int solve(int h, int m) {
		return 24 * 60 - (h * 60 + m);
	}
}
