import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int x = sc.nextInt();
		System.out.println(solve(a, b, x));

		sc.close();
	}

	static String solve(int a, int b, int x) {
		StringBuilder result = new StringBuilder();
		boolean zeroOrOne = a >= b;
		for (int i = x; i >= 0; i--) {
			if (zeroOrOne) {
				if (i <= 1) {
					while (a != 0) {
						result.append(0);
						a--;
					}
				} else {
					result.append(0);
					a--;
				}
			} else {
				if (i <= 1) {
					while (b != 0) {
						result.append(1);
						b--;
					}
				} else {
					result.append(1);
					b--;
				}
			}

			zeroOrOne = !zeroOrOne;
		}

		return result.toString();
	}
}
