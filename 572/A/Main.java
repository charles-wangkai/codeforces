import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int nA = sc.nextInt();
		int nB = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		int[] a = readArray(sc, nA);
		int[] b = readArray(sc, nB);
		System.out.println(solve(a, b, k, m) ? "YES" : "NO");

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static boolean solve(int[] a, int[] b, int k, int m) {
		return a[k - 1] < b[b.length - m];
	}
}
