import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] a = readArray(sc);
		int[] b = readArray(sc);
		System.out.println(solve(a, b));

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

	static String solve(int[] a, int[] b) {
		return String.format("%d %d", Arrays.stream(a).max().getAsInt(), Arrays.stream(b).max().getAsInt());
	}
}
