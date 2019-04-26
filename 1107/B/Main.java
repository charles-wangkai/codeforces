import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int tc = 0; tc < n; tc++) {
			long k = sc.nextLong();
			int x = sc.nextInt();

			System.out.println(solve(k, x));
		}

		sc.close();
	}

	static long solve(long k, int x) {
		return (k - 1) * 9 + x;
	}
}
