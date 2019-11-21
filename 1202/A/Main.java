import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String x = sc.next();
			String y = sc.next();

			System.out.println(solve(x, y));
		}

		sc.close();
	}

	static int solve(String x, String y) {
		int yOneIndex = reverse(y).indexOf('1');

		return reverse(x).indexOf('1', yOneIndex) - yOneIndex;
	}

	static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}
