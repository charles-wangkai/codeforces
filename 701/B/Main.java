import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] x = new int[m];
		int[] y = new int[m];
		for (int i = 0; i < m; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		System.out.println(Arrays.stream(solve(n, x, y)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

		sc.close();
	}

	static long[] solve(int n, int[] x, int[] y) {
		long current = (long) n * n;
		Set<Integer> xSet = new HashSet<>();
		Set<Integer> ySet = new HashSet<>();

		long[] result = new long[x.length];
		for (int i = 0; i < result.length; i++) {
			if (!xSet.contains(x[i])) {
				current -= n - ySet.size();
			}
			if (!ySet.contains(y[i])) {
				current -= n - xSet.size();
			}
			if (!xSet.contains(x[i]) && !ySet.contains(y[i])) {
				current++;
			}
			result[i] = current;

			xSet.add(x[i]);
			ySet.add(y[i]);
		}
		return result;
	}
}
