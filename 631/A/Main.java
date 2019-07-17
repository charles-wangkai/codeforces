import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = readArray(sc, n);
		int[] b = readArray(sc, n);
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
		int result = -1;
		for (int l = 0; l < a.length; l++) {
			int orA = 0;
			int orB = 0;
			for (int r = l; r < a.length; r++) {
				orA |= a[r];
				orB |= b[r];

				result = Math.max(result, orA + orB);
			}
		}
		return result;
	}
}
