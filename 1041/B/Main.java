import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		long x = sc.nextLong();
		long y = sc.nextLong();
		System.out.println(solve(a, b, x, y));

		sc.close();
	}

	static long solve(long a, long b, long x, long y) {
		long g = gcd(x, y);

		return Math.min(a / (x / g), b / (y / g));
	}

	static long gcd(long p, long q) {
		return (q == 0) ? p : gcd(q, p % q);
	}
}
