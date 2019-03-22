import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(solve(n, m));

		sc.close();
	}

	static String solve(int n, int m) {
		if (m < n - 1 || m > 2 * (n + 1)) {
			return "-1";
		}

		StringBuilder result = new StringBuilder();
		boolean zeroTurn = (m == n - 1);
		while (!(n == 0 && m == 0)) {
			if (zeroTurn) {
				result.append("0");
				n--;
			} else {
				int oneCount = (m > n + 1) ? 2 : 1;
				for (int i = 0; i < oneCount; i++) {
					result.append("1");
					m--;
				}
			}

			zeroTurn = !zeroTurn;
		}
		return result.toString();
	}
}
