import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			String s = sc.next();
			String t = sc.next();
			String p = sc.next();

			System.out.println(solve(s, t, p) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(String s, String t, String p) {
		Map<Character, Integer> mergedLetterToCount = mergeLetterToCount(buildLetterToCount(s), buildLetterToCount(p));
		Map<Character, Integer> tLetterToCount = buildLetterToCount(t);

		if (tLetterToCount.keySet().stream()
				.anyMatch(letter -> mergedLetterToCount.getOrDefault(letter, 0) < tLetterToCount.get(letter))) {
			return false;
		}

		int beginIndex = 0;
		for (char letter : s.toCharArray()) {
			int index = t.indexOf(letter, beginIndex);
			if (index == -1) {
				return false;
			}

			beginIndex = index + 1;
		}

		return true;
	}

	static Map<Character, Integer> buildLetterToCount(String str) {
		Map<Character, Integer> letterToCount = new HashMap<>();
		for (char letter : str.toCharArray()) {
			letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
		}
		return letterToCount;
	}

	static Map<Character, Integer> mergeLetterToCount(Map<Character, Integer> letterToCount1,
			Map<Character, Integer> letterToCount2) {
		Map<Character, Integer> merged = new HashMap<>();
		for (char letter : Stream.concat(letterToCount1.keySet().stream(), letterToCount2.keySet().stream())
				.collect(Collectors.toSet())) {
			merged.put(letter, letterToCount1.getOrDefault(letter, 0) + letterToCount2.getOrDefault(letter, 0));
		}
		return merged;
	}
}
