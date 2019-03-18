import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] c = readArray(sc, n);
		int[] a = readArray(sc, m);
		System.out.println(solve(c, a));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int solve(int[] c, int[] a) {
		int result = 0;
		int indexA = 0;
		for (int ci : c) {
			if (indexA < a.length && a[indexA] >= ci) {
				result++;
				indexA++;
			}
		}
		return result;
	}
}
