import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Q = sc.nextInt();
		System.out.println(solve(Q));

		sc.close();
	}

	static String solve(int Q) {
		int result = -1;
		int lower = 1;
		int upper = 1_000_000_000;
		while (lower <= upper) {
			int middle = (lower + upper) / 2;

			int trailingZeroNum = computeTrailingZeroNum(middle);
			if (trailingZeroNum < Q) {
				lower = middle + 1;
			} else {
				if (trailingZeroNum == Q) {
					result = middle;
				}

				upper = middle - 1;
			}
		}

		return (result < 0) ? "No solution" : String.valueOf(result);
	}

	static int computeTrailingZeroNum(int n) {
		return (n == 0) ? 0 : (n / 5 + computeTrailingZeroNum(n / 5));
	}
}
