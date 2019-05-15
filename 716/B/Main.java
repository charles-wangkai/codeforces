import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	static final int TARGET_LENGTH = 26;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		for (int i = 0; i <= s.length() - TARGET_LENGTH; i++) {
			String replacement = replace(s.substring(i, i + TARGET_LENGTH));

			if (replacement != null) {
				return String.format("%s%s%s", s.substring(0, i), replacement, s.substring(i + TARGET_LENGTH))
						.replace('?', 'A');
			}
		}
		return "-1";
	}

	static String replace(String part) {
		Set<Integer> shownLetters = part.chars().filter(ch -> ch != '?').distinct().boxed().collect(Collectors.toSet());

		int[] indices = IntStream.range(0, part.length()).filter(i -> part.charAt(i) == '?').toArray();

		if (shownLetters.size() + indices.length != TARGET_LENGTH) {
			return null;
		}

		int[] unshownLetters = IntStream.rangeClosed('A', 'Z').filter(ch -> !shownLetters.contains(ch)).toArray();

		StringBuilder result = new StringBuilder(part);
		for (int i = 0; i < indices.length; i++) {
			result.setCharAt(indices[i], (char) unshownLetters[i]);
		}
		return result.toString();
	}
}
