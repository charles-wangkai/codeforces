import java.util.Scanner;

public class Main {
	static final int MODULUS = 1_000_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		int result = 0;
		int countB = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == 'a') {
				result = addMod(result, countB);

				countB = multiplyMod(countB, 2);
			} else {
				countB++;
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
