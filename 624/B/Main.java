import java.util.Arrays;
import java.util.Scanner;

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

	static long solve(int[] a) {
		int[] sorted = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();
		for (int i = sorted.length - 2; i >= 0; i--) {
			sorted[i] = Math.max(0, Math.min(sorted[i], sorted[i + 1] - 1));
		}

		return Arrays.stream(sorted).asLongStream().sum();
	}
}
