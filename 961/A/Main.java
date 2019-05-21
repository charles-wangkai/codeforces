import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] c = new int[m];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		System.out.println(solve(n, c));

		sc.close();
	}

	static int solve(int n, int[] c) {
		int[] counts = new int[n];
		for (int ci : c) {
			counts[ci - 1]++;
		}

		return Arrays.stream(counts).min().getAsInt();
	}
}
