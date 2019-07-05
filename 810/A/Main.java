import java.util.Arrays;
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
		int sum = Arrays.stream(a).sum();
		int count = a.length;
		for (int i = 0;; i++) {
			if (sum * 2 / count >= k * 2 - 1) {
				return i;
			}

			sum += k;
			count++;
		}
	}
}
