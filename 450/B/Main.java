import java.util.Scanner;

public class Main {
	static final int MOD_DIVISOR = 1_000_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(solve(x, y, n));

		sc.close();
	}

	static int solve(int x, int y, int n) {
		return mod(new int[] { x, y, y - x, -x, -y, x - y }[(n - 1) % 6]);
	}

	static int mod(int a) {
		return (a % MOD_DIVISOR + MOD_DIVISOR) % MOD_DIVISOR;
	}
}
