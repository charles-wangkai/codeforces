import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = readArray(sc, n);
		int[] y = readArray(sc, n);
		System.out.println(solve(x, y) ? "Yes" : "No");

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static boolean solve(int[] x, int[] y) {
		return Arrays.stream(x).sum() >= Arrays.stream(y).sum();
	}
}
