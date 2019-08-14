import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] s = readArray(sc, n);
		int[] c = readArray(sc, n);
		System.out.println(solve(s, c));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int solve(int[] s, int[] c) {
		int n = s.length;

		int[][] costs = new int[n][4];
		for (int i = 0; i < costs.length; i++) {
			Arrays.fill(costs[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < n; i++) {
			costs[i][1] = c[i];

			for (int j = 2; j <= 3; j++) {
				for (int k = 0; k < i; k++) {
					if (s[k] < s[i] && costs[k][j - 1] != Integer.MAX_VALUE) {
						costs[i][j] = Math.min(costs[i][j], costs[k][j - 1] + c[i]);
					}
				}
			}
		}

		int result = IntStream.range(0, n).map(i -> costs[i][3]).min().getAsInt();

		return (result == Integer.MAX_VALUE) ? -1 : result;
	}
}
