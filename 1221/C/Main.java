import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int c = sc.nextInt();
			int m = sc.nextInt();
			int x = sc.nextInt();

			System.out.println(solve(c, m, x));
		}

		sc.close();
	}

	static int solve(int c, int m, int x) {
		return Math.min(Math.min(c, m), (c + m + x) / 3);
	}
}
