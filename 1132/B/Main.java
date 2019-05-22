import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = readArray(sc, n);
		int m = sc.nextInt();
		int[] q = readArray(sc, m);
		System.out.println(solve(a, q));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static String solve(int[] a, int[] q) {
		Arrays.sort(a);

		long total = Arrays.stream(a).asLongStream().sum();
		return Arrays.stream(q).mapToObj(qi -> String.valueOf(total - a[a.length - qi]))
				.collect(Collectors.joining("\n"));
	}
}
