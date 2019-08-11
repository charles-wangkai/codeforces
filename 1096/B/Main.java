import java.util.Scanner;

public class Main {
	static final int MODULUS = 998_244_353;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		int leftLength = 1;
		while (s.charAt(leftLength) == s.charAt(0)) {
			leftLength++;
		}

		int rightLength = 1;
		while (s.charAt(s.length() - 1 - rightLength) == s.charAt(s.length() - 1)) {
			rightLength++;
		}

		return addMod(addMod(leftLength, rightLength),
				addMod((s.charAt(0) == s.charAt(s.length() - 1)) ? multiplyMod(leftLength, rightLength) : 0, 1));
	}

	static int addMod(int x, int y) {
		return (x + y) % MODULUS;
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MODULUS);
	}
}
