import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		long[] a = readArray(sc, n);
		long[] b = readArray(sc, m);
		System.out.print(solve(a, b));

		sc.close();
	}

	static long[] readArray(Scanner sc, int size) {
		long[] result = new long[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextLong();
		}
		return result;
	}

	static String solve(long[] a, long[] b) {
		StringBuilder result = new StringBuilder();
		int dormitory = 1;
		long minRoom = 1;
		long maxRoom = a[0];
		for (long bi : b) {
			while (bi > maxRoom) {
				minRoom = maxRoom + 1;
				maxRoom += a[dormitory];
				dormitory++;
			}

			result.append(String.format("%d %d\n", dormitory, bi - minRoom + 1));
		}
		return result.toString();
	}
}
