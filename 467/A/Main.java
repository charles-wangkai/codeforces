import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] p = new int[n];
		int[] q = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
			q[i] = sc.nextInt();
		}
		System.out.println(solve(p, q));

		sc.close();
	}

	static int solve(int[] p, int[] q) {
		return (int) IntStream.range(0, p.length).filter(i -> q[i] - p[i] >= 2).count();
	}
}
