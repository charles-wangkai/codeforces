import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			long n = sc.nextLong();
			long k = sc.nextLong();

			System.out.println(solve(n, k));
		}

		sc.close();
	}

	static long solve(long n, long k) {
		long result = 0;
		while (n != 0) {
			if (n % k == 0) {
				result++;
				n /= k;
			} else {
				result += n % k;
				n -= n % k;
			}
		}
		return result;
	}
}
