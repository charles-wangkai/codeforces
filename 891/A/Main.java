import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		int countOne = (int) Arrays.stream(a).filter(x -> x == 1).count();
		if (countOne != 0) {
			return a.length - countOne;
		}

		int minOperationNum = Integer.MAX_VALUE;
		for (int beginIndex = 0; beginIndex < a.length; beginIndex++) {
			int endIndex = beginIndex;
			int g = a[beginIndex];
			while (g != 1 && endIndex + 1 < a.length) {
				endIndex++;
				g = gcd(g, a[endIndex]);
			}

			if (g != 1) {
				continue;
			}

			minOperationNum = Math.min(minOperationNum, endIndex - beginIndex + a.length - 1);
		}

		return (minOperationNum == Integer.MAX_VALUE) ? -1 : minOperationNum;
	}

	static int gcd(int x, int y) {
		return (y == 0) ? x : gcd(y, x % y);
	}
}
