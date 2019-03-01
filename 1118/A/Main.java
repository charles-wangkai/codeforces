import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			long n = sc.nextLong();
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(solve(n, a, b));
		}

		sc.close();
	}

	static long solve(long n, int a, int b) {
		return (n / 2 * Math.min(2 * a, b)) + (n % 2 * a);
	}
}
