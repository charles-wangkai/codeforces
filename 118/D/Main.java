import java.util.Scanner;

public class Main {
	static final int MODULUS = 100_000_000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int k1 = sc.nextInt();
		int k2 = sc.nextInt();
		System.out.println(solve(n1, n2, k1, k2));

		sc.close();
	}

	static int solve(int n1, int n2, int k1, int k2) {
		int[][] ways1 = initWays(n1, n2);
		int[][] ways2 = initWays(n1, n2);

		for (int i = 0; i <= n1; i++) {
			for (int j = 0; j <= n2; j++) {
				for (int k = 1; k <= k1 && k <= i; k++) {
					ways1[i][j] = addMod(ways1[i][j], ways2[i - k][j]);
				}

				for (int k = 1; k <= k2 && k <= j; k++) {
					ways2[i][j] = addMod(ways2[i][j], ways1[i][j - k]);
				}
			}
		}

		return addMod(ways1[n1][n2], ways2[n1][n2]);
	}

	static int[][] initWays(int n1, int n2) {
		int[][] ways = new int[n1 + 1][n2 + 1];
		ways[0][0] = 1;

		return ways;
	}

	static int addMod(int x, int y) {
		return (x + y) % MODULUS;
	}
}
