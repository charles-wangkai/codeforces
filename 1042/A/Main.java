import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, m));

		sc.close();
	}

	static String solve(int[] a, int m) {
		int maxA = Arrays.stream(a).max().getAsInt();

		int minK = Math.max(maxA, divideToCeil(Arrays.stream(a).sum() + m, a.length));
		int maxK = maxA + m;

		return String.format("%d %d", minK, maxK);
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
