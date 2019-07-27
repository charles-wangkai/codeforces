import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		System.out.println(solve(k));

		sc.close();
	}

	static String solve(int k) {
		long[] ways = new long[k + 1];
		ways[0] = 1;

		for (int i = 1; i < ways.length; i++) {
			for (int j = 0; j <= i - 1; j++) {
				ways[i] += ways[j] * ways[i - 1 - j];
			}
		}

		return String.format("%d %d", ways[k], k + 1);
	}
}
