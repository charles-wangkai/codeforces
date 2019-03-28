import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();
		}
		System.out.println(String.join(" ", Arrays.stream(solve(p)).mapToObj(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static int[] solve(int[] p) {
		return IntStream.range(0, p.length).map(beginIndex -> findTwoHole(p, beginIndex)).toArray();
	}

	static int findTwoHole(int[] p, int beginIndex) {
		boolean[] visited = new boolean[p.length];

		for (int i = beginIndex;; i = p[i] - 1) {
			if (visited[i]) {
				return i + 1;
			}

			visited[i] = true;
		}
	}
}
