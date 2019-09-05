import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int tc = 0; tc < n; tc++) {
			long l = sc.nextLong();
			long r = sc.nextLong();

			System.out.println(solve(l, r));
		}

		sc.close();
	}

	static long solve(long l, long r) {
		long result = l;
		for (long mask = 1; (result | mask) <= r; mask <<= 1) {
			result |= mask;
		}

		return result;
	}
}
