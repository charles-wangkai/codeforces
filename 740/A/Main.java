import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(solve(n, a, b, c));

		sc.close();
	}

	static long solve(int n, int a, int b, int c) {
		long result = Long.MAX_VALUE;
		for (int aCount = 0; aCount <= 3; aCount++) {
			for (int bCount = 0; bCount <= 3; bCount++) {
				for (int cCount = 0; cCount <= 3; cCount++) {
					if ((n + aCount + 2 * bCount + 3 * cCount) % 4 == 0) {
						result = Math.min(result, (long) aCount * a + (long) bCount * b + (long) cCount * c);
					}
				}
			}
		}
		return result;
	}
}
