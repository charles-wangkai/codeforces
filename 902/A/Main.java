import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.println(solve(a, b, m) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] a, int[] b, int m) {
		int maxLimit = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > maxLimit) {
				break;
			}

			maxLimit = Math.max(maxLimit, b[i]);
		}

		return maxLimit == m;
	}
}
