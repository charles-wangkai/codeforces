import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, x, y));

		sc.close();
	}

	static int solve(int[] a, int x, int y) {
		for (int i = 0;; i++) {
			if (isValid(a, x, y, i)) {
				return i + 1;
			}
		}
	}

	static boolean isValid(int[] a, int x, int y, int d) {
		return !IntStream.rangeClosed(d - x, d + y).anyMatch(i -> i >= 0 && i < a.length && i != d && a[i] <= a[d]);
	}
}
