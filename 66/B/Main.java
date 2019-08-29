import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] heights = new int[n];
		for (int i = 0; i < heights.length; i++) {
			heights[i] = sc.nextInt();
		}
		System.out.println(solve(heights));

		sc.close();
	}

	static int solve(int[] heights) {
		int n = heights.length;

		int[] lefts = new int[n];
		int left = 0;
		for (int i = 0; i < lefts.length; i++) {
			if (i != 0 && heights[i - 1] > heights[i]) {
				left = i;
			}

			lefts[i] = left;
		}

		int[] rights = new int[n];
		int right = n - 1;
		for (int i = n - 1; i >= 0; i--) {
			if (i != n - 1 && heights[i + 1] > heights[i]) {
				right = i;
			}

			rights[i] = right;
		}

		return IntStream.range(0, n).map(i -> rights[i] - lefts[i] + 1).max().getAsInt();
	}
}
