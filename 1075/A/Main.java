import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long x = sc.nextLong();
		long y = sc.nextLong();
		System.out.println(solve(n, x, y));

		sc.close();
	}

	static String solve(long n, long x, long y) {
		return computeMoveNum(1, 1, x, y) <= computeMoveNum(n, n, x, y) ? "White" : "Black";
	}

	static long computeMoveNum(long x1, long y1, long x2, long y2) {
		return Math.min(Math.abs(x1 - x2), Math.abs(y1 - y2));
	}
}
