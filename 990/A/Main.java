import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long m = sc.nextLong();
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(n, m, a, b));

		sc.close();
	}

	static long solve(long n, long m, int a, int b) {
		return Math.min(n % m * b, (m - n % m) * a);
	}
}
