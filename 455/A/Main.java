import java.util.Scanner;

public class Main {
	static final int LIMIT = 100000;

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

	static long solve(int[] a) {
		int[] counts = new int[LIMIT + 1];
		for (int ai : a) {
			counts[ai]++;
		}

		long[] maxScores = new long[counts.length];
		for (int i = 1; i < maxScores.length; i++) {
			maxScores[i] = Math.max(maxScores[i - 1], (i >= 2 ? maxScores[i - 2] : 0) + (long) i * counts[i]);
		}
		return maxScores[maxScores.length - 1];
	}
}
