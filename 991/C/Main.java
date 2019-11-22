import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		System.out.println(solve(n));

		sc.close();
	}

	static long solve(long n) {
		long result = -1;
		long lower = 1;
		long upper = n;
		while (lower <= upper) {
			long middle = (lower + upper) / 2;

			if (check(n, middle)) {
				result = middle;
				upper = middle - 1;
			} else {
				lower = middle + 1;
			}
		}

		return result;
	}

	static boolean check(long n, long k) {
		long count1 = 0;
		long remain = n;
		while ((count1 + remain) * 2 >= n) {
			long taken1 = Math.min(k, remain);
			count1 += taken1;
			remain -= taken1;

			if (count1 * 2 >= n) {
				return true;
			}

			remain -= remain / 10;
		}

		return false;
	}
}
