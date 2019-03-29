import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		System.out.println(solve(x, y) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(int[] x, int[] y) {
		return Arrays.stream(x).filter(xi -> xi < 0).count() <= 1 || Arrays.stream(x).filter(xi -> xi > 0).count() <= 1;
	}
}
