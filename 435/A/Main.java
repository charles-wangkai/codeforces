import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, m));

		sc.close();
	}

	static int solve(int[] a, int m) {
		int result = 0;
		int remain = 0;
		for (int ai : a) {
			if (ai > remain) {
				result++;
				remain = m;
			}

			remain -= ai;
		}
		return result;
	}
}
