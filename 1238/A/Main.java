import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			long x = sc.nextLong();
			long y = sc.nextLong();

			System.out.println(solve(x, y) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(long x, long y) {
		return x - y != 1;
	}
}
