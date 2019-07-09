
// https://blog.csdn.net/incincible/article/details/52050656

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long[] A = new long[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextLong();
		}
		System.out.println(solve(A));

		sc.close();
	}

	static long solve(long[] A) {
		long result = 0;
		for (int i = 62; i >= 0; i--) {
			for (int j = 0; j < A.length; j++) {
				if (isBitSet(A[j], i)) {
					if (!isBitSet(result, i)) {
						result ^= A[j];
					}

					long temp = A[j];
					for (int k = 0; k < A.length; k++) {
						if (isBitSet(A[k], i)) {
							A[k] ^= temp;
						}
					}

					break;
				}
			}
		}
		return result;
	}

	static boolean isBitSet(long x, int shift) {
		return (x & (1L << shift)) != 0;
	}
}
