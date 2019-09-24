import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] M = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				M[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve(M));

		sc.close();
	}

	static String solve(int[][] M) {
		int n = M.length;

		int[] a = new int[n];
		a[0] = (int) Math.round(Math.sqrt((long) M[0][1] * M[0][2] / M[1][2]));
		for (int i = 1; i < a.length; i++) {
			a[i] = M[0][i] / a[0];
		}

		return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}
}
