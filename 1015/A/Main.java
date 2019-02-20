import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] l = new int[n];
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}

		int[] points = solve(l, r, m);
		System.out.println(points.length);
		System.out.println(String.join(" ", Arrays.stream(points).mapToObj(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static int[] solve(int[] l, int[] r, int m) {
		return IntStream.rangeClosed(1, m)
				.filter(x -> IntStream.range(0, l.length).allMatch(i -> !(x >= l[i] && x <= r[i]))).toArray();
	}
}
