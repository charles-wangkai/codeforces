import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		int[] l = new int[q];
		int[] r = new int[q];
		for (int i = 0; i < q; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		System.out.print(solve(l, r));

		sc.close();
	}

	static String solve(int[] l, int[] r) {
		return IntStream.range(0, l.length).mapToObj(i -> String.valueOf(computeSum(r[i]) - computeSum(l[i] - 1)))
				.collect(Collectors.joining("\n"));
	}

	static int computeSum(int limit) {
		return ((limit % 2 == 0) ? 1 : -1) * (limit + 1) / 2;
	}
}
