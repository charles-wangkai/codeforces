import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static final String[] PATTERNS = { "twone", "one", "two" };
	static final int[] OFFSETS = { 2, 1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			String s = sc.next();

			System.out.println(solve(s));
		}

		sc.close();
	}

	static String solve(String s) {
		List<Integer> removedIndices = new ArrayList<>();
		int index = 0;
		while (index < s.length()) {
			boolean removed = false;
			for (int i = 0; i < PATTERNS.length; ++i) {
				if (s.startsWith(PATTERNS[i], index)) {
					removedIndices.add(index + OFFSETS[i]);
					index += PATTERNS[i].length();
					removed = true;

					break;
				}
			}

			if (!removed) {
				++index;
			}
		}

		return String.format("%d\n%s", removedIndices.size(),
				removedIndices.stream().map(x -> String.valueOf(x + 1)).collect(Collectors.joining(" ")));
	}
}
