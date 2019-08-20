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
		int[] valueToLeftComparisonNum = new int[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			valueToLeftComparisonNum[a[i]] = i + 1;
		}

		long totalLeftComparisonNum = Arrays.stream(b).mapToLong(bi -> valueToLeftComparisonNum[bi]).sum();
		long totalRightComparisonNum = Arrays.stream(b).mapToLong(bi -> a.length + 1 - valueToLeftComparisonNum[bi])
				.sum();

		return String.format("%d %d", totalLeftComparisonNum, totalRightComparisonNum);
	}
}
