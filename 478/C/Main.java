import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt();
		int g = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(r, g, b));

		sc.close();
	}

	static int solve(int r, int g, int b) {
		int lower = 0;
		int upper = (int) (((long) r + g + b) / 3);
		int result = -1;
		while (lower <= upper) {
			int middle = (int) (((long) lower + upper) / 2);

			if (isPossible(r, g, b, middle)) {
				result = middle;

				lower = middle + 1;
			} else {
				upper = middle - 1;
			}
		}
		return result;
	}

	static boolean isPossible(int r, int g, int b, int table) {
		return Math.min(r, table * 2L) + Math.min(g, table * 2L) + Math.min(b, table * 2L) >= table * 3L;
	}
}
