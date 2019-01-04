import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		System.out.println(solve(a, p));

		sc.close();
	}

	static int solve(int[] a, int[] p) {
		int result = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			minPrice = Math.min(minPrice, p[i]);
			result += a[i] * minPrice;
		}
		return result;
	}
}
