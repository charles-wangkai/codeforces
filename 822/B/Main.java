import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		sc.nextInt();
		String s = sc.next();
		String t = sc.next();
		System.out.println(solve(s, t));

		sc.close();
	}

	static String solve(String s, String t) {
		int[] diffIndicesForMinLength = null;
		for (int i = 0; i + s.length() <= t.length(); i++) {
			int[] diffIndices = buildDiffIndices(s, t, i);

			if (diffIndicesForMinLength == null || diffIndices.length < diffIndicesForMinLength.length) {
				diffIndicesForMinLength = diffIndices;
			}
		}

		return String.format("%d\n%s", diffIndicesForMinLength.length, Arrays.stream(diffIndicesForMinLength)
				.mapToObj(x -> String.valueOf(x + 1)).collect(Collectors.joining(" ")));
	}

	static int[] buildDiffIndices(String s, String t, int beginIndex) {
		return IntStream.range(0, s.length()).filter(i -> s.charAt(i) != t.charAt(beginIndex + i)).toArray();
	}
}
