import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long k = sc.nextLong();
		System.out.println(solve(n, k));

		sc.close();
	}

	static long solve(long n, long k) {
		return divideToCeil(k, n);
	}

	static long divideToCeil(long x, long y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
