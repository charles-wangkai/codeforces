import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] p = new int[n / 2];
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();
		}
		System.out.println(solve(p));

		sc.close();
	}

	static int solve(int[] p) {
		return Math.min(computeMoveNum(p, 1), computeMoveNum(p, 2));
	}

	static int computeMoveNum(int[] p, int offset) {
		Arrays.sort(p);

		return IntStream.range(0, p.length).map(i -> Math.abs(p[i] - (i * 2 + offset))).sum();
	}
}
