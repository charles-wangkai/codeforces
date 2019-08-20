import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		int m = sc.nextInt();
		long k = sc.nextLong();
		long[] p = new long[m];
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextLong();
		}
		System.out.println(solve(n, p, k));

		sc.close();
	}

	static int solve(long n, long[] p, long k) {
		int result = 0;
		int beginIndex = 0;
		while (beginIndex != p.length) {
			int endIndex = beginIndex;
			while (endIndex + 1 != p.length
					&& (p[endIndex + 1] - beginIndex - 1) / k == (p[beginIndex] - beginIndex - 1) / k) {
				endIndex++;
			}

			beginIndex = endIndex + 1;
			result++;
		}

		return result;
	}
}
