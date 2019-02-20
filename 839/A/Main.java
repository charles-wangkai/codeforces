import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, k));

		sc.close();
	}

	static int solve(int[] a, int k) {
		int total = 0;
		int current = 0;
		for (int i = 0; i < a.length; i++) {
			current += a[i];

			int given = Math.min(8, current);

			total += given;
			if (total >= k) {
				return i + 1;
			}

			current -= given;
		}
		return -1;
	}
}
