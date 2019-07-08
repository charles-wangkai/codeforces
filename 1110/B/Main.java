import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] b = new int[n];
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}
		System.out.println(solve(b, m, k));

		sc.close();
	}

	static int solve(int[] b, int m, int k) {
		return b.length + IntStream.range(0, b.length - 1).map(i -> b[i + 1] - b[i] - 1).boxed().sorted()
				.limit(b.length - k).mapToInt(x -> x).sum();
	}
}
