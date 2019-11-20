import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MODULUS = 1_000_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int[] c = new int[k];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		System.out.println(solve(c));

		sc.close();
	}

	static int solve(int[] c) {
		int result = 1;

		int remain = Arrays.stream(c).sum();
		for (int i = c.length - 1; i >= 0; i--) {
			result = multiplyMod(result, C(remain - 1, c[i] - 1));
			remain -= c[i];
		}

		return result;
	}

	static int C(int n, int r) {
		int result = 1;
		for (int i = 0; i < r; i++) {
			result = multiplyMod(result,
					multiplyMod(n - i, BigInteger.valueOf(i + 1).modInverse(BigInteger.valueOf(MODULUS)).intValue()));
		}

		return result;
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MODULUS);
	}
}
