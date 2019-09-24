import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = readArray(sc, n);
		int m = sc.nextInt();
		int[] b = readArray(sc, m);
		int[] c = readArray(sc, m);
		System.out.println(solve(a, b, c));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}

		return result;
	}

	static int solve(int[] a, int[] b, int[] c) {
		Map<Integer, Integer> languageToCount = new HashMap<>();
		for (int language : a) {
			languageToCount.put(language, languageToCount.getOrDefault(language, 0) + 1);
		}

		return IntStream.range(0, b.length).boxed()
				.max((index1,
						index2) -> !languageToCount.getOrDefault(b[index1], 0)
								.equals(languageToCount.getOrDefault(b[index2], 0))
										? Integer.compare(languageToCount.getOrDefault(b[index1], 0),
												languageToCount.getOrDefault(b[index2], 0))
										: Integer.compare(languageToCount.getOrDefault(c[index1], 0),
												languageToCount.getOrDefault(c[index2], 0)))
				.get() + 1;
	}
}
