import java.util.Scanner;

public class Main {
	static final int MODULUS = 998_244_353;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		int result = 0;
		for (int ai : a) {
			int placeValue = 1;
			while (ai != 0) {
				int digit = ai % 10;
				result = addMod(result, multiplyMod(multiplyMod(digit, a.length), multiplyMod(placeValue, 11)));

				ai /= 10;
				placeValue = multiplyMod(placeValue, 100);
			}
		}

		return result;
	}

	static int addMod(int x, int y) {
		return (x + y) % MODULUS;
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MODULUS);
	}
}
