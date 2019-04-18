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

	static long solve(int[] a) {
		long result = a[a.length - 1];
		for (int i = a.length - 2; i >= 0; i--) {
			a[i] = Math.max(0, Math.min(a[i], a[i + 1] - 1));

			result += a[i];
		}
		return result;
	}
}
