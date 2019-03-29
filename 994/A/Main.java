import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] x = readArray(sc, n);
		int[] y = readArray(sc, m);
		System.out
				.println(String.join(" ", Arrays.stream(solve(x, y)).mapToObj(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int[] solve(int[] x, int[] y) {
		boolean[] fingerprints = new boolean[10];
		Arrays.stream(y).forEach(yi -> fingerprints[yi] = true);

		return Arrays.stream(x).filter(xi -> fingerprints[xi]).toArray();
	}
}
