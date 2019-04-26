import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = readArray(sc, n);
		int[] y = readArray(sc, n);
		System.out.println(solve(x, y));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static String solve(int[] x, int[] y) {
		Set<Integer> values = IntStream.concat(Arrays.stream(x), Arrays.stream(y)).distinct().boxed()
				.collect(Collectors.toSet());

		int pairNum = 0;
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y.length; j++) {
				if (values.contains(x[i] ^ y[j])) {
					pairNum++;
				}
			}
		}

		return (pairNum % 2 == 0) ? "Karen" : "Koyomi";
	}
}
