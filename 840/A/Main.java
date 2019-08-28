import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int[] a = readArray(sc, m);
		int[] b = readArray(sc, m);
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

	static String solve(int[] a, int[] b) {
		int[] sortedA = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();
		int[] toIndices = IntStream.range(0, a.length).boxed().sorted((i1, i2) -> Integer.compare(b[i2], b[i1]))
				.mapToInt(x -> x).toArray();

		int[] result = new int[a.length];
		for (int i = 0; i < result.length; i++) {
			result[toIndices[i]] = sortedA[i];
		}

		return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}
}
