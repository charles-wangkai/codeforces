import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] q = new int[n - 1];
		for (int i = 0; i < q.length; i++) {
			q[i] = sc.nextInt();
		}
		System.out.println(solve(q));

		sc.close();
	}

	static String solve(int[] q) {
		int n = q.length + 1;

		long[] permutation = new long[n];
		for (int i = 1; i < permutation.length; i++) {
			permutation[i] = permutation[i - 1] + q[i - 1];
		}

		long offset = 1 - Arrays.stream(permutation).min().getAsLong();
		for (int i = 0; i < permutation.length; i++) {
			permutation[i] += offset;
		}

		if (Arrays.stream(permutation).max().getAsLong() == n && Arrays.stream(permutation).distinct().count() == n) {
			return Arrays.stream(permutation).mapToObj(String::valueOf).collect(Collectors.joining(" "));
		} else {
			return "-1";
		}
	}
}
