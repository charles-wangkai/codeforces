import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] lights = new int[n][2 * m];
		for (int i = 0; i < lights.length; i++) {
			for (int j = 0; j < lights[i].length; j++) {
				lights[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve(lights));

		sc.close();
	}

	static int solve(int[][] lights) {
		return IntStream.range(0, lights.length).map(i -> (int) IntStream.range(0, lights[i].length / 2)
				.filter(j -> lights[i][j * 2] == 1 || lights[i][j * 2 + 1] == 1).count()).sum();
	}
}
