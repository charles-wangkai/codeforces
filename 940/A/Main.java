import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.println(solve(x, d));

		sc.close();
	}

	static int solve(int[] x, int d) {
		Arrays.sort(x);

		int result = x.length - 1;
		for (int beginIndex = 0; beginIndex < x.length; beginIndex++) {
			int endIndex = beginIndex;
			while (endIndex + 1 < x.length && x[endIndex + 1] - x[beginIndex] <= d) {
				endIndex++;
			}

			result = Math.min(result, x.length - (endIndex - beginIndex + 1));
		}

		return result;
	}
}
