import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(int[] a) {
		int step = (a.length - a[0]) % a.length;

		return IntStream.range(0, a.length).allMatch(
				i -> i == ((i % 2 == 0) ? ((a[i] + step) % a.length) : ((a[i] - step + a.length) % a.length)));
	}
}
