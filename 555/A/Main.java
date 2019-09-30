import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] a = new int[k][];
		for (int i = 0; i < a.length; i++) {
			int m = sc.nextInt();
			a[i] = new int[m];
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve(n, a));

		sc.close();
	}

	static int solve(int n, int[][] a) {
		int oneLength = 1;
		for (int[] ai : a) {
			if (ai[0] == 1) {
				while (oneLength < ai.length && ai[oneLength] - ai[oneLength - 1] == 1) {
					oneLength++;
				}
			}
		}

		return Arrays.stream(a).mapToInt(ai -> ai.length - 1).sum() + (n - 1) - (oneLength - 1) * 2;
	}
}
