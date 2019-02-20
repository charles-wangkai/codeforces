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

		int result = 0;
		for (int i = 1; i < a.length; i++) {
			int target = Math.max(a[i], a[i - 1] + 1);
			result += target - a[i];
			a[i] = target;
		}
		return result;
	}
}
