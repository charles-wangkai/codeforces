import java.util.Scanner;

public class Main {
	static final int MOD_DIVISOR = 1_000_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		int[] ways = new int[4];
		ways[0] = 1;

		for (int i = 0; i < n; i++) {
			int[] nextWays = new int[ways.length];
			for (int j = 0; j < nextWays.length; j++) {
				for (int k = 0; k < ways.length; k++) {
					if (k != j) {
						nextWays[j] = addMod(nextWays[j], ways[k]);
					}
				}
			}

			ways = nextWays;
		}

		return ways[0];
	}

	static int addMod(int x, int y) {
		return (x + y) % MOD_DIVISOR;
	}
}
