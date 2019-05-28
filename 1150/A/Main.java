import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		int[] a = readArray(sc, n);
		int[] b = readArray(sc, m);
		System.out.println(solve(a, b, r));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int solve(int[] a, int[] b, int r) {
		int minA = Arrays.stream(a).min().getAsInt();
		int maxB = Arrays.stream(b).max().getAsInt();
		return r + Math.max(0, r / minA * (maxB - minA));
	}
}
