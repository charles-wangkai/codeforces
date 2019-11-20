import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static final int PRIZE_NUM = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] p = readArray(sc, n);
		int[] costs = readArray(sc, PRIZE_NUM);
		System.out.println(solve(p, costs));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}

		return result;
	}

	static String solve(int[] p, int[] costs) {
		int remain = 0;
		long[] counts = new long[PRIZE_NUM];
		for (int pi : p) {
			remain += pi;

			for (int i = costs.length - 1; i >= 0; i--) {
				counts[i] += remain / costs[i];
				remain %= costs[i];
			}
		}

		return String.format("%s\n%d", Arrays.stream(counts).mapToObj(String::valueOf).collect(Collectors.joining(" ")),
				remain);
	}
}
