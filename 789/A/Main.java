import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < w.length; i++) {
			w[i] = sc.nextInt();
		}
		System.out.println(solve(w, k));

		sc.close();
	}

	static int solve(int[] w, int k) {
		return divideToCeil(Arrays.stream(w).map(x -> divideToCeil(x, k)).sum(), 2);
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
