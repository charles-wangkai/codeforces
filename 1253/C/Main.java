import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, m));

		sc.close();
	}

	static String solve(int[] a, int m) {
		a = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

		long[] result = new long[a.length];
		long total = 0;
		long[] partSums = new long[m];
		for (int i = 0; i < result.length; i++) {
			total += partSums[i % m];
			total += a[i];
			result[i] = total;
			partSums[i % m] += a[i];
		}

		return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}
}
