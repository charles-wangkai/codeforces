import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print(solve(a, m, k));

		sc.close();
	}

	static String solve(int[] a, int m, int k) {
		int[] beautyIndices = IntStream.range(0, a.length).boxed().sorted((i1, i2) -> Integer.compare(a[i2], a[i1]))
				.limit(m * k).sorted().mapToInt(x -> x).toArray();

		return String.format("%d\n%s", Arrays.stream(beautyIndices).mapToLong(i -> a[i]).sum(),
				IntStream.range(0, k - 1).mapToObj(i -> String.valueOf(beautyIndices[i * m + m - 1] + 1))
						.collect(Collectors.joining(" ")));
	}
}
