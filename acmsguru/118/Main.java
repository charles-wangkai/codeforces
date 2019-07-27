import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		for (int tc = 0; tc < K; tc++) {
			int N = sc.nextInt();
			int[] A = new int[N];
			for (int i = 0; i < A.length; i++) {
				A[i] = sc.nextInt();
			}

			System.out.println(solve(A));
		}

		sc.close();
	}

	static int solve(int[] A) {
		BigInteger sum = BigInteger.ZERO;
		BigInteger product = BigInteger.ONE;
		for (int ai : A) {
			product = product.multiply(BigInteger.valueOf(ai));
			sum = sum.add(product);
		}

		int digitRoot = computeDigitRoot(sum.toString());
		while (digitRoot >= 10) {
			digitRoot = computeDigitRoot(String.valueOf(digitRoot));
		}
		return digitRoot;
	}

	static int computeDigitRoot(String s) {
		return s.chars().map(ch -> ch - '0').sum();
	}
}
