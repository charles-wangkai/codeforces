import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int bx = sc.nextInt();
		int[] x = readArray(sc, n);
		int m = sc.nextInt();
		int by = sc.nextInt();
		int[] y = readArray(sc, m);
		System.out.println(solve(x, bx, y, by));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static char solve(int[] x, int bx, int[] y, int by) {
		long decimalX = convertToDecimal(x, bx);
		long decimalY = convertToDecimal(y, by);

		if (decimalX < decimalY) {
			return '<';
		} else if (decimalX > decimalY) {
			return '>';
		} else {
			return '=';
		}
	}

	static long convertToDecimal(int[] digits, int base) {
		long result = 0;
		for (int digit : digits) {
			result = result * base + digit;
		}
		return result;
	}
}
