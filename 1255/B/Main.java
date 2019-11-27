import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a, m));
		}

		sc.close();
	}

	static String solve(int[] a, int m) {
		if (a.length == 2 || m != a.length) {
			return "-1";
		}

		return String.format("%d\n%s", Arrays.stream(a).sum() * 2,
				IntStream.range(0, a.length).mapToObj(i -> String.format("%d %d", i + 1, (i + 1) % a.length + 1))
						.collect(Collectors.joining("\n")));
	}
}
