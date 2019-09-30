import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long b = sc.nextLong();
		System.out.println(solve(b));

		sc.close();
	}

	static int solve(long b) {
		int result = 1;
		for (int i = 2; (long) i * i <= b; i++) {
			int exponent = 0;
			while (b % i == 0) {
				b /= i;
				exponent++;
			}

			result *= exponent + 1;
		}
		if (b != 1) {
			result *= 2;
		}

		return result;
	}
}
