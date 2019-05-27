import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, m, k));

		sc.close();
	}

	static int solve(int[] a, int m, int k) {
		int result = 0;
		for (int ai : a) {
			if (ai == 1) {
				if (m != 0) {
					m--;
				} else {
					result++;
				}
			} else {
				if (k != 0) {
					k--;
				} else if (m != 0) {
					m--;
				} else {
					result++;
				}
			}
		}
		return result;
	}
}
