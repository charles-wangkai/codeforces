import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] x = readArray(sc);
		int[] y = readArray(sc);
		System.out.println(solve(n, m, x, y) ? "Yes" : "No");

		sc.close();
	}

	static int[] readArray(Scanner sc) {
		int size = sc.nextInt();

		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}

		return result;
	}

	static boolean solve(int n, int m, int[] x, int[] y) {
		boolean[] boys = new boolean[n];
		for (int xi : x) {
			boys[xi] = true;
		}

		boolean[] girls = new boolean[m];
		for (int yi : y) {
			girls[yi] = true;
		}

		while (true) {
			boolean changed = false;

			for (int i = 0; i < n * m; i++) {
				int boyIndex = i % boys.length;
				int girlIndex = i % girls.length;

				if ((!boys[boyIndex] && girls[girlIndex]) || (boys[boyIndex] && !girls[girlIndex])) {
					boys[boyIndex] = true;
					girls[girlIndex] = true;
					changed = true;
				}
			}

			if (!changed) {
				break;
			}
		}

		return IntStream.range(0, boys.length).allMatch(i -> boys[i])
				&& IntStream.range(0, girls.length).allMatch(i -> girls[i]);
	}
}
