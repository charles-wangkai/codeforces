import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] A = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = sc.nextInt();
			}
		}

		int[] solution = solve(A);
		System.out.println(solution.length);
		System.out.println(String.join(" ", Arrays.stream(solution).mapToObj(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static int[] solve(int[][] A) {
		return IntStream.range(0, A.length).filter(i -> !Arrays.stream(A[i]).anyMatch(x -> x == 1 || x == 3))
				.map(i -> i + 1).toArray();
	}
}
