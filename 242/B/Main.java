import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] l = new int[n];
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		System.out.println(solve(l, r));

		sc.close();
	}

	static int solve(int[] l, int[] r) {
		int minL = Arrays.stream(l).min().getAsInt();
		int maxR = Arrays.stream(r).max().getAsInt();

		return IntStream.range(0, l.length).filter(i -> l[i] == minL && r[i] == maxR).map(i -> i + 1).findFirst()
				.orElse(-1);
	}
}
