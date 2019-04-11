import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String directions = sc.next();
		int[] x = new int[directions.length()];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.println(solve(x, directions));

		sc.close();
	}

	static int solve(int[] x, String directions) {
		return IntStream.range(0, x.length - 1).filter(i -> directions.substring(i, i + 2).equals("RL"))
				.map(i -> (x[i + 1] - x[i]) / 2).min().orElse(-1);
	}
}
