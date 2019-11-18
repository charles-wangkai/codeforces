import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int[] a = readArray(sc, n);
			int[] b = readArray(sc, n);

			System.out.println(solve(a, b) ? "YES" : "NO");
		}

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}

		return result;
	}

	static boolean solve(int[] a, int[] b) {
		int[] diffIndices = IntStream.range(0, a.length).filter(i -> a[i] != b[i]).toArray();

		return IntStream.range(0, a.length).allMatch(i -> a[i] <= b[i]) && (diffIndices.length == 0
				|| IntStream.rangeClosed(diffIndices[0], diffIndices[diffIndices.length - 1]).map(i -> b[i] - a[i])
						.distinct().count() == 1);
	}
}
