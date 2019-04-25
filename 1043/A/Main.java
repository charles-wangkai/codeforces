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
		return Math.max(Arrays.stream(a).max().getAsInt(), divideToCeil(Arrays.stream(a).sum() * 2 + 1, a.length));
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
