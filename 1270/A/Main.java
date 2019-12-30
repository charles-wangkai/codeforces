import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int n = sc.nextInt();
			int k1 = sc.nextInt();
			int k2 = sc.nextInt();
			int[] a = readArray(sc, k1);
			int[] b = readArray(sc, k2);

			System.out.println(solve(n, a, b) ? "YES" : "NO");
		}

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; ++i) {
			result[i] = sc.nextInt();
		}

		return result;
	}

	static boolean solve(int n, int[] a, int[] b) {
		return Arrays.stream(a).anyMatch(x -> x == n);
	}
}
