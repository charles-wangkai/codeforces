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

	static String solve(int[] a) {
		int max = Arrays.stream(a).max().getAsInt();
		int[] diffs = Arrays.stream(a).map(x -> max - x).toArray();

		int g = diffs[0];
		for (int i = 1; i < diffs.length; i++) {
			g = gcd(g, diffs[i]);
		}

		return String.format("%d %d", computePeopleNum(diffs, g), g);
	}

	static long computePeopleNum(int[] diffs, int g) {
		return Arrays.stream(diffs).mapToLong(diff -> diff / g).sum();
	}

	static int gcd(int x, int y) {
		return (y == 0) ? x : gcd(y, x % y);
	}
}
