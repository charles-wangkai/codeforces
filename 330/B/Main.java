import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m];
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.println(solve(n, a, b));

		sc.close();
	}

	static String solve(int n, int[] a, int[] b) {
		Set<Integer> appeared = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).boxed()
				.collect(Collectors.toSet());

		int center = IntStream.rangeClosed(1, n).filter(x -> !appeared.contains(x)).findAny().getAsInt();

		return String.format("%d\n%s", n - 1, IntStream.rangeClosed(1, n).filter(x -> x != center)
				.mapToObj(x -> String.format("%d %d", center, x)).collect(Collectors.joining("\n")));
	}
}
