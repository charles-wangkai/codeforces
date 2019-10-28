import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int[] d = new int[n];
			for (int i = 0; i < d.length; i++) {
				d[i] = sc.nextInt();
			}

			System.out.println(solve(d));
		}

		sc.close();
	}

	static long solve(int[] d) {
		Arrays.sort(d);

		long number = (long) d[0] * d[d.length - 1];
		for (int i = 0, j = d.length - 1; i <= j; i++, j--) {
			if ((long) d[i] * d[j] != number) {
				return -1;
			}
		}

		int count = 0;
		for (int i = 2; (long) i * i <= number; i++) {
			if (number % i == 0) {
				count++;
			}
		}

		if ((d.length + 1) / 2 != count) {
			return -1;
		}

		return number;
	}
}
