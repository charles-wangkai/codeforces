import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a, k));
		}

		sc.close();
	}

	static int solve(int[] a, int k) {
		int min = Arrays.stream(a).min().getAsInt();
		int max = Arrays.stream(a).max().getAsInt();

		return (min + k < max - k) ? -1 : (min + k);
	}
}
