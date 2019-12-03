import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int f = sc.nextInt();
		int[] k = new int[n];
		int[] l = new int[n];
		for (int i = 0; i < n; i++) {
			k[i] = sc.nextInt();
			l[i] = sc.nextInt();
		}
		System.out.println(solve(k, l, f));

		sc.close();
	}

	static long solve(int[] k, int[] l, int f) {
		return IntStream.range(0, k.length).mapToLong(i -> Math.min(k[i], l[i])).sum()
				+ IntStream.range(0, k.length).mapToObj(i -> Math.min(k[i], Math.max(0, l[i] - k[i])))
						.sorted(Collections.reverseOrder()).limit(f).mapToLong(x -> x).sum();
	}
}
