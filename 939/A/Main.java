import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] f = new int[n + 1];
		for (int i = 1; i < f.length; i++) {
			f[i] = sc.nextInt();
		}
		System.out.println(solve(f) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] f) {
		return IntStream.range(1, f.length).anyMatch(i -> f[f[f[i]]] == i);
	}
}
