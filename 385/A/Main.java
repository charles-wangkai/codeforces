import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.println(solve(x, c));

		sc.close();
	}

	static int solve(int[] x, int c) {
		return Math.max(0, IntStream.range(0, x.length - 1).map(i -> x[i] - x[i + 1]).max().getAsInt() - c);
	}
}
