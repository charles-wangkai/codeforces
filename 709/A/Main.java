import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int b = sc.nextInt();
		int d = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, b, d));

		sc.close();
	}

	static int solve(int[] a, int b, int d) {
		int result = 0;
		int waste = 0;
		for (int ai : a) {
			if (ai <= b) {
				waste += ai;

				if (waste > d) {
					result++;
					waste = 0;
				}
			}
		}
		return result;
	}
}
