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
		return IntStream.range(0, a.length).map(x -> computeCost(a, x)).min().getAsInt();
	}

	static int computeCost(int[] a, int x) {
		return IntStream.range(0, a.length).map(i -> Math.max(i, x) * 4 * a[i]).sum();
	}
}
