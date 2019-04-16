import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.println(solve(a, b, m));

		sc.close();
	}

	static int solve(int[] a, int[] b, int m) {
		if (Arrays.stream(b).asLongStream().sum() > m) {
			return -1;
		}

		long sum = Arrays.stream(a).asLongStream().sum();
		if (sum <= m) {
			return 0;
		}

		List<Integer> diffs = IntStream.range(0, a.length).map(i -> a[i] - b[i]).boxed().sorted()
				.collect(Collectors.toList());
		for (int i = a.length - 1;; i--) {
			sum -= diffs.get(i);

			if (sum <= m) {
				return a.length - i;
			}
		}
	}
}
