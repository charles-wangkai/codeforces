import java.util.Arrays;
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
		Arrays.sort(a);

		int total = Arrays.stream(a).sum();
		int sum = 0;
		for (int i = a.length - 1;; i--) {
			sum += a[i];

			if (sum * 2 > total) {
				return a.length - i;
			}
		}
	}
}
