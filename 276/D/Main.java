import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long l = sc.nextLong();
		long r = sc.nextLong();
		System.out.println(solve(l, r));

		sc.close();
	}

	static long solve(long l, long r) {
		if (l == r) {
			return 0;
		}

		for (long mask = 1L << 62;; mask >>= 1) {
			if ((l & mask) != (r & mask)) {
				return (mask << 1) - 1;
			}
		}
	}
}
