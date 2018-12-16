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
		if (k <= (n + 1) / 2) {
			return k * 2 - 1;
		} else {
			return (k - (n + 1) / 2) * 2;
		}
	}
}
