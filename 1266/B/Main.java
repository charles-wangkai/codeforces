import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			long x = sc.nextLong();

			System.out.println(solve(x) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(long x) {
		return x >= 15 && x % 14 >= 1 && x % 14 <= 6;
	}
}
