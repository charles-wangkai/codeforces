import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.println(solve(a, b));

		sc.close();
	}

	static String solve(int[] a, int[] b) {
		if (IntStream.range(0, a.length).anyMatch(i -> a[i] != b[i])) {
			return "rated";
		} else if (IntStream.range(0, b.length - 1).anyMatch(i -> b[i] < b[i + 1])) {
			return "unrated";
		} else {
			return "maybe";
		}
	}
}
