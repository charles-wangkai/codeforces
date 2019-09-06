import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n, k));

		sc.close();
	}

	static int solve(int n, int k) {
		int result = -1;
		int lower = 1;
		int upper = n;
		while (lower <= upper) {
			int middle = (lower + upper) / 2;

			if (check(n, k, middle)) {
				result = middle;

				upper = middle - 1;
			} else {
				lower = middle + 1;
			}
		}

		return result;
	}

	static boolean check(int n, int k, int v) {
		int lineNum = 0;
		while (v != 0) {
			lineNum += v;

			v /= k;
		}

		return lineNum >= n;
	}
}
