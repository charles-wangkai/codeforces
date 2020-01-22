import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] r = new int[q];
		int[] c = new int[q];
		for (int i = 0; i < q; ++i) {
			r[i] = sc.nextInt() - 1;
			c[i] = sc.nextInt() - 1;
		}
		System.out.println(solve(n, r, c));

		sc.close();
	}

	static String solve(int n, int[] r, int[] c) {
		boolean[][] blocked = new boolean[2][n];
		int blockCount = 0;

		List<String> result = new ArrayList<>();
		for (int i = 0; i < r.length; ++i) {
			if (blocked[r[i]][c[i]]) {
				if (c[i] != 0 && (blocked[1 - r[i]][c[i] - 1] || blocked[1 - r[i]][c[i]]) && !blocked[r[i]][c[i] - 1]) {
					--blockCount;
				}

				if (c[i] != n - 1 && (blocked[1 - r[i]][c[i]] || blocked[1 - r[i]][c[i] + 1])
						&& !blocked[r[i]][c[i] + 1]) {
					--blockCount;
				}
			} else {
				if (c[i] != 0 && (blocked[1 - r[i]][c[i] - 1] || blocked[1 - r[i]][c[i]]) && !blocked[r[i]][c[i] - 1]) {
					++blockCount;
				}

				if (c[i] != n - 1 && (blocked[1 - r[i]][c[i]] || blocked[1 - r[i]][c[i] + 1])
						&& !blocked[r[i]][c[i] + 1]) {
					++blockCount;
				}
			}
			blocked[r[i]][c[i]] = !blocked[r[i]][c[i]];

			result.add((blockCount == 0) ? "Yes" : "No");
		}

		return String.join("\n", result);
	}
}
