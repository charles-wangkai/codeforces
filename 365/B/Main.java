import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		int count = 0;
		int maxCount = 0;
		for (int i = 2; i < a.length; i++) {
			if (a[i] == a[i - 1] + a[i - 2]) {
				count++;
				maxCount = Math.max(maxCount, count);
			} else {
				count = 0;
			}
		}

		return Math.min(2, a.length) + maxCount;
	}
}
