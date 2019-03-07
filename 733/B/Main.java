import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] l = new int[n];
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		System.out.println(solve(l, r));

		sc.close();
	}

	static int solve(int[] l, int[] r) {
		int sumL = Arrays.stream(l).sum();
		int sumR = Arrays.stream(r).sum();

		int result = 0;
		int maxDiff = Math.abs(sumL - sumR);
		for (int i = 0; i < l.length; i++) {
			int diff = Math.abs((sumL - l[i] + r[i]) - (sumR - r[i] + l[i]));

			if (diff > maxDiff) {
				result = i + 1;
				maxDiff = diff;
			}
		}
		return result;
	}
}
