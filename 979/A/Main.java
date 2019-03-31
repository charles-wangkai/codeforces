import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		System.out.println(solve(n));

		sc.close();
	}

	static long solve(long n) {
		if (n == 0) {
			return 0;
		}

		return (n % 2 == 0) ? (n + 1) : ((n + 1) / 2);
	}
}
