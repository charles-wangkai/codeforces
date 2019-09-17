import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		System.out.print(solve(a));

		sc.close();
	}

	static String solve(int[][] a) {
		int n = a.length;

		for (int i = 0;; i++) {
			if (Arrays.stream(a[i]).anyMatch(x -> x == n - 1)) {
				return Arrays.stream(a[i]).mapToObj(x -> String.valueOf((x == 0) ? n : x))
						.collect(Collectors.joining(" "));
			}
		}
	}
}
