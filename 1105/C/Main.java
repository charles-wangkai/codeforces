import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int DIVISOR = 3;
	static final int MODULUS = 1_000_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		System.out.println(solve(n, l, r));

		sc.close();
	}

	static int solve(int n, int l, int r) {
		int[] counts = IntStream.range(0, DIVISOR).map(i -> computeNumBetween(l, r, i)).toArray();

		int[] wayNums = new int[DIVISOR];
		wayNums[0] = 1;

		for (int i = 0; i < n; i++) {
			int[] nextWayNums = new int[wayNums.length];
			for (int j = 0; j < wayNums.length; j++) {
				for (int k = 0; k < counts.length; k++) {
					nextWayNums[(j + k) % DIVISOR] = addMod(nextWayNums[(j + k) % DIVISOR],
							multiplyMod(wayNums[j], counts[k]));
				}
			}

			wayNums = nextWayNums;
		}

		return wayNums[0];
	}

	static int computeNumBetween(int l, int r, int remainder) {
		return Math.floorDiv(r - remainder, DIVISOR) - divideToCeil(l - remainder, DIVISOR) + 1;
	}

	static int divideToCeil(int x, int y) {
		return Math.floorDiv(x, y) + (x % y == 0 ? 0 : 1);
	}

	static int addMod(int x, int y) {
		return (x + y) % MODULUS;
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MODULUS);
	}
}
