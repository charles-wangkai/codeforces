import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] h = new int[n];
		for (int i = 0; i < h.length; i++) {
			h[i] = sc.nextInt();
		}
		System.out.println(solve(h));

		sc.close();
	}

	static int solve(int[] h) {
		return h.length * 2 - 1 + IntStream.range(0, h.length).map(i -> Math.abs(h[i] - (i == 0 ? 0 : h[i - 1]))).sum();
	}
}
