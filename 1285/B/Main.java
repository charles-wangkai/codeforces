import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; ++i) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int[] a) {
		long leftSum = 0;
		for (int i = 0; i < a.length; ++i) {
			leftSum += a[i];
			if (leftSum <= 0) {
				return false;
			}
		}

		long rightSum = 0;
		for (int i = a.length - 1; i >= 0; --i) {
			rightSum += a[i];
			if (rightSum <= 0) {
				return false;
			}
		}

		return true;
	}
}
