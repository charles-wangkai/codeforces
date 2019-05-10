import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = readArray(sc, n);
		int[] b = readArray(sc, m);
		System.out.println(solve(a, b));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int solve(int[] a, int[] b) {
		int candidate = Math.max(Arrays.stream(a).min().getAsInt() * 2, Arrays.stream(a).max().getAsInt());

		return (candidate < Arrays.stream(b).min().getAsInt()) ? candidate : -1;
	}
}
