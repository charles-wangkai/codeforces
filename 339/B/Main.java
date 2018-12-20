import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(n, a));

		sc.close();
	}

	static long solve(int n, int[] a) {
		return IntStream.range(0, a.length).map(i -> (a[i] - (i == 0 ? 1 : a[i - 1]) + n) % n).asLongStream().sum();
	}
}
