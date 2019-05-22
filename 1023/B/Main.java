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
		return Math.max(0, Math.min(n, k - 1) - ((k + 2) / 2) + 1);
	}
}
