import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int h = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, h));

		sc.close();
	}

	static int solve(int[] a, int h) {
		return Arrays.stream(a).map(x -> (x <= h) ? 1 : 2).sum();
	}
}
