import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, s));

		sc.close();
	}

	static long solve(int[] a, int s) {
		Arrays.sort(a);

		int index = a.length / 2;
		return Math.abs(a[index] - s) + IntStream.range(0, index).map(i -> Math.max(0, a[i] - s)).asLongStream().sum()
				+ IntStream.range(index + 1, a.length).map(i -> Math.max(0, s - a[i])).asLongStream().sum();
	}
}
