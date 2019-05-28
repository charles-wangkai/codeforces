import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long m = sc.nextLong();
		System.out.println(solve(n, m));

		sc.close();
	}

	static String solve(long n, long m) {
		long a = n;
		long b = m;
		while (a != 0 && b != 0) {
			if (a >= 2 * b) {
				a %= 2 * b;
			} else if (b >= 2 * a) {
				b %= 2 * a;
			} else {
				break;
			}
		}

		return String.format("%d %d", a, b);
	}
}
