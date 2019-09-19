import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			int[] x = new int[n];
			int[] y = new int[n];
			int[] f1 = new int[n];
			int[] f2 = new int[n];
			int[] f3 = new int[n];
			int[] f4 = new int[n];
			for (int i = 0; i < n; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
				f1[i] = sc.nextInt();
				f2[i] = sc.nextInt();
				f3[i] = sc.nextInt();
				f4[i] = sc.nextInt();
			}

			System.out.println(solve(x, y, f1, f2, f3, f4));
		}

		sc.close();
	}

	static String solve(int[] x, int[] y, int[] f1, int[] f2, int[] f3, int[] f4) {
		int minX = -100000;
		int maxX = 100000;
		int minY = -100000;
		int maxY = 100000;

		for (int i = 0; i < x.length; i++) {
			if (f1[i] == 0) {
				minX = Math.max(minX, x[i]);
			}
			if (f2[i] == 0) {
				maxY = Math.min(maxY, y[i]);
			}
			if (f3[i] == 0) {
				maxX = Math.min(maxX, x[i]);
			}
			if (f4[i] == 0) {
				minY = Math.max(minY, y[i]);
			}

			if (minX > maxX || minY > maxY) {
				return "0";
			}
		}

		return String.format("1 %d %d", minX, minY);
	}
}
