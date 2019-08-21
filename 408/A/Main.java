import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] k = readArray(sc, n);
		int[][] m = new int[n][];
		for (int i = 0; i < n; i++) {
			m[i] = readArray(sc, k[i]);
		}
		System.out.println(solve(m));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}

		return result;
	}

	static int solve(int[][] m) {
		return IntStream.range(0, m.length).map(i -> 5 * Arrays.stream(m[i]).sum() + 15 * m[i].length).min().getAsInt();
	}
}
