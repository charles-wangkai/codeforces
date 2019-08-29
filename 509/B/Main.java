import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print(solve(a, k));

		sc.close();
	}

	static String solve(int[] a, int k) {
		int min = Arrays.stream(a).min().getAsInt();
		int max = Arrays.stream(a).max().getAsInt();

		if (max - min > k) {
			return "NO";
		}

		return String.format("YES\n%s",
				IntStream.range(0, a.length).mapToObj(i -> IntStream.range(0, a[i])
						.mapToObj(j -> String.valueOf(Math.max(1, j - min + 1))).collect(Collectors.joining(" ")))
						.collect(Collectors.joining("\n")));
	}
}
