import java.util.Scanner;

public class Main {
	static final int MODULUS = 1_000_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int[] r = readArray(sc, h);
		int[] c = readArray(sc, w);
		System.out.println(solve(r, c));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}

		return result;
	}

	static int solve(int[] r, int[] c) {
		int h = r.length;
		int w = c.length;

		Boolean[][] cells = new Boolean[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < r[i]; j++) {
				cells[i][j] = true;
			}

			if (r[i] != w) {
				cells[i][r[i]] = false;
			}
		}
		for (int j = 0; j < w; j++) {
			for (int i = 0; i < c[j]; i++) {
				if (cells[i][j] != null && !cells[i][j]) {
					return 0;
				}

				cells[i][j] = true;
			}

			if (c[j] != h) {
				if (cells[c[j]][j] != null && cells[c[j]][j]) {
					return 0;
				}

				cells[c[j]][j] = false;
			}
		}

		int result = 1;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (cells[i][j] == null) {
					result = multiplyMod(result, 2);
				}
			}
		}

		return result;
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MODULUS);
	}
}
