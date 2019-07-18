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
		Arrays.sort(a);
		Arrays.sort(b);

		int bIndex = 0;
		for (int i = 0; i < a.length; i++) {
			while (bIndex < b.length && b[bIndex] < a[i]) {
				bIndex++;
			}

			if (bIndex == b.length) {
				return a.length - i;
			}

			bIndex++;
		}
		return 0;
	}
}
