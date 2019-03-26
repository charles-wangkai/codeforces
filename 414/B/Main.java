import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static final int MOD_DIVISOR = 1_000_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n, k));

		sc.close();
	}

	static int solve(int n, int k) {
		int result = 0;

		Map<Integer, Integer> lastToWayNum = new HashMap<>();
		BigInteger c = BigInteger.ONE;
		for (int i = 0; i < k; i++) {
			Map<Integer, Integer> nextLastToWayNum = new HashMap<>();

			if (i == 0) {
				for (int j = 1; j <= n; j++) {
					nextLastToWayNum.put(j, 1);
				}
			} else {
				for (int last : lastToWayNum.keySet()) {
					for (int nextLast = last * 2; nextLast <= n; nextLast += last) {
						nextLastToWayNum.put(nextLast,
								addMod(nextLastToWayNum.getOrDefault(nextLast, 0), lastToWayNum.get(last)));
					}
				}
			}

			if (i != 0) {
				c = c.multiply(BigInteger.valueOf(k - i)).divide(BigInteger.valueOf(i));
			}

			result = addMod(result, multiplyMod(nextLastToWayNum.values().stream().reduce(0, Main::addMod),
					c.mod(BigInteger.valueOf(MOD_DIVISOR)).intValue()));

			lastToWayNum = nextLastToWayNum;
		}

		return result;
	}

	static int addMod(int x, int y) {
		return (x + y) % MOD_DIVISOR;
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MOD_DIVISOR);
	}
}
