import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int[] a = new int[12];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(k, a));

		sc.close();
	}

	static int solve(int k, int[] a) {
		Arrays.sort(a);

		int sum = 0;
		int result = 0;
		while (sum < k && result < a.length) {
			sum += a[a.length - 1 - result];
			result++;
		}
		return (sum < k) ? -1 : result;
	}
}
