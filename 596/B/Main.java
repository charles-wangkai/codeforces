import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] b = new int[n];
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}
		System.out.println(solve(b));

		sc.close();
	}

	static long solve(int[] b) {
		return IntStream.range(0, b.length).map(i -> Math.abs(b[i] - (i == 0 ? 0 : b[i - 1]))).asLongStream().sum();
	}
}
