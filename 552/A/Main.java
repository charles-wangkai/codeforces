import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x1 = new int[n];
		int[] y1 = new int[n];
		int[] x2 = new int[n];
		int[] y2 = new int[n];
		for (int i = 0; i < n; i++) {
			x1[i] = sc.nextInt();
			y1[i] = sc.nextInt();
			x2[i] = sc.nextInt();
			y2[i] = sc.nextInt();
		}
		System.out.println(solve(x1, y1, x2, y2));

		sc.close();
	}

	static int solve(int[] x1, int[] y1, int[] x2, int[] y2) {
		return IntStream.range(0, x1.length).map(i -> (x2[i] - x1[i] + 1) * (y2[i] - y1[i] + 1)).sum();
	}
}
