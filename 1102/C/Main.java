import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, x, y));

		sc.close();
	}

	static int solve(int[] a, int x, int y) {
		return (x > y) ? a.length : (((int) Arrays.stream(a).filter(ai -> ai <= x).count() + 1) / 2);
	}
}
