import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(solve(n, k, A, B));

		sc.close();
	}

	static long solve(int n, int k, int A, int B) {
		if (k == 1) {
			return (n - 1L) * A;
		}

		long result = 0;
		while (true) {
			if (n < k) {
				result += (n - 1L) * A;

				return result;
			}

			int multiple = n / k * k;
			result += (long) (n - multiple) * A + Math.min(multiple / k * (k - 1L) * A, B);

			n = multiple / k;
		}
	}
}
