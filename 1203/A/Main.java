import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			int[] p = new int[n];
			for (int i = 0; i < p.length; i++) {
				p[i] = sc.nextInt();
			}

			System.out.println(solve(p) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int[] p) {
		return canDanceClockwise(p) || canDanceCounterclockwise(p);
	}

	static boolean canDanceClockwise(int[] p) {
		return IntStream.range(0, p.length).allMatch(i -> p[i] == p.length || p[i] + 1 == p[(i + 1) % p.length]);
	}

	static boolean canDanceCounterclockwise(int[] p) {
		return IntStream.range(0, p.length).allMatch(i -> p[i] == 1 || p[i] - 1 == p[(i + 1) % p.length]);
	}
}
