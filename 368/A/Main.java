import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		System.out.println(solve(a, d, m));

		sc.close();
	}

	static int solve(int[] a, int d, int m) {
		return Arrays.stream(a).sorted().limit(m).sum() - d * Math.max(0, m - a.length);
	}
}
