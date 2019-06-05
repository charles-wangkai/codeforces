import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, t));

		sc.close();
	}

	static int solve(int[] a, int t) {
		for (int i = 0;; i++) {
			int readingTime = 86400 - a[i];

			if (readingTime >= t) {
				return i + 1;
			}

			t -= readingTime;
		}
	}
}
