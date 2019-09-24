import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, m));

		sc.close();
	}

	static int solve(int[] a, int m) {
		int[] counts = new int[m + 1];
		for (int ai : a) {
			counts[ai]++;
		}

		return IntStream.range(1, counts.length)
				.map(i -> IntStream.range(i + 1, counts.length).map(j -> counts[i] * counts[j]).sum()).sum();
	}
}
