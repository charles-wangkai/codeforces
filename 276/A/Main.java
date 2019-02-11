import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] f = new int[n];
		int[] t = new int[n];
		for (int i = 0; i < n; i++) {
			f[i] = sc.nextInt();
			t[i] = sc.nextInt();
		}
		System.out.println(solve(f, t, k));

		sc.close();
	}

	static int solve(int[] f, int[] t, int k) {
		return IntStream.range(0, f.length).map(i -> f[i] - Math.max(0, t[i] - k)).max().getAsInt();
	}
}
