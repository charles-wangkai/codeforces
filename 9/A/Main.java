import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Y = sc.nextInt();
		int W = sc.nextInt();
		System.out.println(solve(Y, W));

		sc.close();
	}

	static String solve(int Y, int W) {
		int numerator = 7 - Math.max(Y, W);
		int denominator = 6;
		int g = gcd(numerator, denominator);
		numerator /= g;
		denominator /= g;
		return String.format("%d/%d", numerator, denominator);
	}

	static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}
