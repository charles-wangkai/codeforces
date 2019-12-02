import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int r = sc.nextInt();
			int g = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(solve(r, g, b));
		}

		sc.close();
	}

	static int solve(int r, int g, int b) {
		int[] sorted = IntStream.of(r, g, b).sorted().toArray();

		return sorted[0] + Math.min((sorted[1] + sorted[2] - sorted[0]) / 2, sorted[1]);
	}
}
