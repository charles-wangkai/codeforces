import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a, k));
		}

		sc.close();
	}

	static String solve(int[] a, int k) {
		if (Arrays.stream(a).asLongStream().sum() % 2 != k % 2) {
			return "NO";
		}

		int[] r = IntStream.concat(IntStream.range(0, a.length).filter(i -> a[i] % 2 != 0).limit(k - 1).map(x -> x + 1),
				IntStream.of(a.length)).toArray();
		if (r.length != k) {
			return "NO";
		}

		return String.format("YES\n%s", Arrays.stream(r).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}
}
