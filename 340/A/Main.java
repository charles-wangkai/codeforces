import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(x, y, a, b));

		sc.close();
	}

	static int solve(int x, int y, int a, int b) {
		int d = x * y / gcd(x, y);

		int lower = divideToCeil(a, d) * d;
		int upper = b / d * d;

		return upper / d - lower / d + 1;
	}

	static int gcd(int x, int y) {
		return (y == 0) ? x : gcd(y, x % y);
	}

	static int divideToCeil(int p, int q) {
		return p / q + (p % q == 0 ? 0 : 1);
	}
}
