import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.println(solve(a, b));

		sc.close();
	}

	static int solve(int[] a, int[] b) {
		int n = a.length;

		int result = 1;
		for (int i = 0; i < n; i++) {
			int minDraw;
			if (i == 0) {
				minDraw = 1;
			} else {
				minDraw = Math.max(a[i - 1], b[i - 1]) + ((a[i - 1] == b[i - 1]) ? 1 : 0);
			}

			int maxDraw = Math.min(a[i], b[i]);

			result += Math.max(0, maxDraw - minDraw + 1);
		}

		return result;
	}
}
