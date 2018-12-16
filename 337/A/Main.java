import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] f = new int[m];
		for (int i = 0; i < f.length; i++) {
			f[i] = sc.nextInt();
		}
		System.out.println(solve(n, f));

		sc.close();
	}

	static int solve(int n, int[] f) {
		Arrays.sort(f);

		return IntStream.range(0, f.length - n + 1).map(i -> f[i + n - 1] - f[i]).min().getAsInt();
	}
}
