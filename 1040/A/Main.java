import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		System.out.println(solve(c, a, b));

		sc.close();
	}

	static int solve(int[] c, int a, int b) {
		int result = 0;
		for (int i = 0, j = c.length - 1; i <= j; i++, j--) {
			if (c[i] == 2) {
				if (c[j] == 2) {
					result += Math.min(a, b) * (i == j ? 1 : 2);
				} else {
					result += getCost(c[j], a, b);
				}
			} else {
				if (c[j] == 2) {
					result += getCost(c[i], a, b);
				} else {
					if (c[i] != c[j]) {
						return -1;
					}
				}
			}
		}
		return result;
	}

	static int getCost(int color, int a, int b) {
		return (color == 1) ? b : a;
	}
}
