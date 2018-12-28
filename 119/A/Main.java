import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(solve(a, b, n));

		sc.close();
	}

	static int solve(int a, int b, int n) {
		boolean simonTurn = true;
		while (n != 0) {
			if (simonTurn) {
				n -= gcd(a, n);
			} else {
				n -= gcd(b, n);
			}

			simonTurn = !simonTurn;
		}
		return simonTurn ? 1 : 0;
	}

	static int gcd(int x, int y) {
		return (y == 0) ? x : gcd(y, x % y);
	}
}
