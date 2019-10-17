import java.util.HashMap;
import java.util.Map;
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
		Map<Integer, Integer> carToExitIndex = new HashMap<>();
		for (int i = 0; i < b.length; i++) {
			carToExitIndex.put(b[i], i);
		}

		int result = 0;
		int maxExitIndex = -1;
		for (int ai : a) {
			int exitIndex = carToExitIndex.get(ai);
			if (exitIndex < maxExitIndex) {
				result++;
			} else {
				maxExitIndex = exitIndex;
			}
		}

		return result;
	}
}
