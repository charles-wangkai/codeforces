import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int b = sc.nextInt();
			int p = sc.nextInt();
			int f = sc.nextInt();
			int h = sc.nextInt();
			int c = sc.nextInt();

			System.out.println(solve(b, p, f, h, c));
		}

		sc.close();
	}

	static int solve(int b, int p, int f, int h, int c) {
		return Math.max(computeProfit(b, p, f, h, c), computeProfit(b, f, p, c, h));
	}

	static int computeProfit(int b, int count1, int count2, int price1, int price2) {
		int unit1 = Math.min(b / 2, count1);
		int unit2 = Math.min(b / 2 - unit1, count2);

		return unit1 * price1 + unit2 * price2;
	}
}
