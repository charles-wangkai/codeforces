import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int d = sc.nextInt();

			System.out.println(solve(l, r, d));
		}

		sc.close();
	}

	static int solve(int l, int r, int d) {
		return (d >= l && d <= r) ? ((r / d + 1) * d) : d;
	}
}
