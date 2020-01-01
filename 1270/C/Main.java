import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; ++i) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a));
		}

		sc.close();
	}

	static String solve(int[] a) {
		int xor = Arrays.stream(a).reduce(0, (x, y) -> x ^ y);
		long sum = Arrays.stream(a).asLongStream().sum();

		return String.format("2\n%d %d", xor, sum + xor);
	}
}
