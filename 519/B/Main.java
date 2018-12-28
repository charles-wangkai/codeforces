import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = readArray(sc, n);
		int[] b = readArray(sc, n - 1);
		int[] c = readArray(sc, n - 2);
		System.out.println(solve(a, b, c));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static String solve(int[] a, int[] b, int[] c) {
		return String.format("%d\n%d", subtract(a, b), subtract(b, c));
	}

	static int subtract(int[] x, int[] y) {
		Arrays.sort(x);
		Arrays.sort(y);

		for (int i = 0; i < y.length; i++) {
			if (x[i] != y[i]) {
				return x[i];
			}
		}

		return x[x.length - 1];
	}
}
