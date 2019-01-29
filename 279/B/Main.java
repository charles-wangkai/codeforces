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
		int endIndex = 0;
		int sum = 0;
		while (endIndex < a.length && sum + a[endIndex] <= t) {
			sum += a[endIndex];
			endIndex++;
		}
		int maxLength = endIndex;

		for (int beginIndex = 1; beginIndex < a.length; beginIndex++) {
			sum -= a[beginIndex - 1];

			while (endIndex < a.length && sum + a[endIndex] <= t) {
				sum += a[endIndex];
				endIndex++;
			}

			maxLength = Math.max(maxLength, endIndex - beginIndex);
		}

		return maxLength;
	}
}
