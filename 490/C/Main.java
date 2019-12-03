import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(s, a, b));

		sc.close();
	}

	static String solve(String s, int a, int b) {
		int[] leftRemainders = buildLeftRemainders(s, a);
		int[] rightRemainders = buildRightRemainders(s, b);

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i + 1) != '0' && leftRemainders[i] == 0 && rightRemainders[i + 1] == 0) {
				return String.format("YES\n%s\n%s", s.substring(0, i + 1), s.substring(i + 1));
			}
		}

		return "NO";
	}

	static int addMod(int x, int y, int modulus) {
		return (x + y) % modulus;
	}

	static int multiplyMod(int x, int y, int modulus) {
		return (int) ((long) x * y % modulus);
	}

	static int[] buildLeftRemainders(String s, int a) {
		int[] result = new int[s.length()];
		int remainder = 0;
		for (int i = 0; i < result.length; i++) {
			remainder = addMod(multiplyMod(remainder, 10, a), s.charAt(i) - '0', a);
			result[i] = remainder;
		}

		return result;
	}

	static int[] buildRightRemainders(String s, int b) {
		int[] result = new int[s.length()];
		int remainder = 0;
		int placeValue = 1;
		for (int i = result.length - 1; i >= 0; i--) {
			remainder = addMod(multiplyMod(placeValue, s.charAt(i) - '0', b), remainder, b);
			result[i] = remainder;

			placeValue = multiplyMod(placeValue, 10, b);
		}

		return result;
	}
}
