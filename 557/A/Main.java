import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int min1 = sc.nextInt();
		int max1 = sc.nextInt();
		int min2 = sc.nextInt();
		int max2 = sc.nextInt();
		int min3 = sc.nextInt();
		int max3 = sc.nextInt();
		System.out.println(solve(n, min1, max1, min2, max2, min3, max3));

		sc.close();
	}

	static String solve(int n, int min1, int max1, int min2, int max2, int min3, int max3) {
		for (int x1 = max1;; x1--) {
			int remain = n - x1;
			if (remain >= min2 + min3 && remain <= max2 + max3) {
				int x2;
				int x3;
				if (remain - max2 >= min3) {
					x2 = max2;
					x3 = remain - max2;
				} else {
					x2 = remain - min3;
					x3 = min3;
				}

				return String.format("%d %d %d", x1, x2, x3);
			}
		}
	}
}
