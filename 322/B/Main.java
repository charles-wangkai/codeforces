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
		int result = computeIndependentNum(r, g, b);
		if (r >= 1 && g >= 1 && b >= 1) {
			result = Math.max(result, 1 + computeIndependentNum(r - 1, g - 1, b - 1));
		}
		if (r >= 2 && g >= 2 && b >= 2) {
			result = Math.max(result, 2 + computeIndependentNum(r - 2, g - 2, b - 2));
		}

		return result;
	}

	static int computeIndependentNum(int r, int g, int b) {
		return r / 3 + g / 3 + b / 3;
	}
}
