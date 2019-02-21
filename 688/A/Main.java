import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();
		int[][] absents = new int[d][n];
		for (int i = 0; i < d; i++) {
			String line = sc.next();

			for (int j = 0; j < n; j++) {
				absents[i][j] = line.charAt(j) - '0';
			}
		}
		System.out.println(solve(absents));

		sc.close();
	}

	static int solve(int[][] absents) {
		int result = 0;
		int count = 0;
		for (int[] day : absents) {
			if (Arrays.stream(day).allMatch(x -> x == 1)) {
				count = 0;
			} else {
				count++;
				result = Math.max(result, count);
			}
		}
		return result;
	}
}
