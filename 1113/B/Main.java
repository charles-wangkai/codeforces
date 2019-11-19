import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		int min = Arrays.stream(a).min().getAsInt();
		int max = Arrays.stream(a).max().getAsInt();
		int sum = Arrays.stream(a).sum();

		int[] maxMultiples = new int[max + 1];
		for (int ai : a) {
			for (int x = 1; x < maxMultiples.length; x++) {
				if (ai % x == 0) {
					maxMultiples[x] = Math.max(maxMultiples[x], ai);
				}
			}
		}

		return IntStream.range(1, maxMultiples.length).filter(x -> maxMultiples[x] != 0)
				.map(x -> sum - min - maxMultiples[x] + min * x + maxMultiples[x] / x).min().getAsInt();
	}
}
