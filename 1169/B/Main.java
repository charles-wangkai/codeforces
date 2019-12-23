import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m];
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.println(solve(n, a, b) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int n, int[] a, int[] b) {
		int m = a.length;

		for (int v1 : new int[] { a[0], b[0] }) {
			OptionalInt optionalIndex = IntStream.range(0, m).filter(i -> a[i] != v1 && b[i] != v1).findAny();
			if (!optionalIndex.isPresent()) {
				return true;
			}

			int index = optionalIndex.getAsInt();
			for (int v2 : new int[] { a[index], b[index] }) {
				if (IntStream.range(0, m).allMatch(i -> a[i] == v1 || a[i] == v2 || b[i] == v1 || b[i] == v2)) {
					return true;
				}
			}
		}

		return false;
	}
}
