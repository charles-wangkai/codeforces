import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		System.out.println(solve(n));

		sc.close();
	}

	static long solve(long n) {
		for (int i = 2; (long) i * i <= n; i++) {
			while (n % ((long) i * i) == 0) {
				n /= i;
			}
		}
		return n;
	}
}
