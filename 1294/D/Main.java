import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		int x = sc.nextInt();
		int[] y = new int[q];
		for (int i = 0; i < y.length; ++i) {
			y[i] = sc.nextInt();
		}
		System.out.println(solve(y, x));

		sc.close();
	}

	static String solve(int[] y, int x) {
		boolean[] appeared = new boolean[y.length + 1];
		int mex = 0;
		int[] nexts = IntStream.range(0, x).toArray();

		List<Integer> result = new ArrayList<>();
		for (int yi : y) {
			int remainder = yi % x;
			if (nexts[remainder] < appeared.length) {
				appeared[nexts[remainder]] = true;
				nexts[remainder] += x;
			}

			while (appeared[mex]) {
				++mex;
			}

			result.add(mex);
		}

		return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
	}
}
