import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] a = readArray(sc);
		int[] q = readArray(sc);
		Arrays.stream(solve(a, q)).forEach(System.out::println);

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

	static int[] solve(int[] a, int[] q) {
		int start = 1;
		int[] starts = new int[a.length];
		for (int i = 0; i < starts.length; i++) {
			starts[i] = start;
			start += a[i];
		}

		int[] result = new int[q.length];
		for (int i = 0; i < result.length; i++) {
			int index = Arrays.binarySearch(starts, q[i]);
			if (index < 0) {
				index = -1 - index - 1;
			}

			result[i] = index + 1;
		}
		return result;
	}
}
