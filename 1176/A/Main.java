import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			long n = sc.nextLong();

			System.out.println(solve(n));
		}

		sc.close();
	}

	static int solve(long n) {
		int exponent2 = 0;
		while (n % 2 == 0) {
			exponent2++;
			n /= 2;
		}

		int exponent3 = 0;
		while (n % 3 == 0) {
			exponent3++;
			n /= 3;
		}

		int exponent5 = 0;
		while (n % 5 == 0) {
			exponent5++;
			n /= 5;
		}

		return (n == 1) ? (exponent2 + exponent3 * 2 + exponent5 * 3) : -1;
	}
}
