import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[k];
			for (int i = 0; i < a.length; ++i) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(n, s, a));
		}

		sc.close();
	}

	static int solve(int n, int s, int[] a) {
		Set<Integer> closed = Arrays.stream(a).boxed().collect(Collectors.toSet());

		return Math.min(computeDistance(closed, s, 0, -1), computeDistance(closed, s, n + 1, 1));
	}

	static int computeDistance(Set<Integer> closed, int s, int end, int offset) {
		for (int i = s; i != end; i += offset) {
			if (!closed.contains(i)) {
				return Math.abs(i - s);
			}
		}

		return Integer.MAX_VALUE;
	}
}
