import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(solve(x, y));

		sc.close();
	}

	static char solve(int x, int y) {
		if (x <= 4 && y <= 4) {
			int left = pow(x, y);
			int right = pow(y, x);

			if (left < right) {
				return '<';
			} else if (left > right) {
				return '>';
			} else {
				return '=';
			}
		} else if (x == 1) {
			return '<';
		} else if (y == 1) {
			return '>';
		} else if (x < y) {
			return '>';
		} else if (x > y) {
			return '<';
		} else {
			return '=';
		}
	}

	static int pow(int base, int exponent) {
		int result = 1;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
}
