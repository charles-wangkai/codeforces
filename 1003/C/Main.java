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

	static double solve(int[] a, int k) {
		double result = -1;
		for (int i = 0; i < a.length; i++) {
			double sum = 0;
			for (int j = i; j < a.length; j++) {
				sum += a[j];

				if (j - i + 1 >= k) {
					result = Math.max(result, sum / (j - i + 1.0));
				}
			}
		}

		return result;
	}
}
