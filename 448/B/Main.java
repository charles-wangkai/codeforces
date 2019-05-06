import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String t = sc.next();
		System.out.println(solve(s, t));

		sc.close();
	}

	static String solve(String s, String t) {
		if (canByOnlyRemove(s, t)) {
			return "automaton";
		} else if (canByOnlySwap(s, t)) {
			return "array";
		} else if (canByBoth(s, t)) {
			return "both";
		} else {
			return "need tree";
		}
	}

	static boolean canByOnlyRemove(String s, String t) {
		int beginIndex = 0;
		for (char target : t.toCharArray()) {
			beginIndex = s.indexOf(target, beginIndex);

			if (beginIndex < 0) {
				return false;
			}

			beginIndex++;
		}

		return true;
	}

	static boolean canByOnlySwap(String s, String t) {
		Map<Character, Integer> letterToCountS = buildLetterToCount(s);
		Map<Character, Integer> letterToCountT = buildLetterToCount(t);

		return letterToCountS.equals(letterToCountT);
	}

	static boolean canByBoth(String s, String t) {
		Map<Character, Integer> letterToCountS = buildLetterToCount(s);
		Map<Character, Integer> letterToCountT = buildLetterToCount(t);

		return letterToCountT.keySet().stream()
				.allMatch(letter -> letterToCountS.getOrDefault(letter, 0) >= letterToCountT.get(letter));
	}

	static Map<Character, Integer> buildLetterToCount(String str) {
		Map<Character, Integer> letterToCount = new HashMap<>();
		for (char letter : str.toCharArray()) {
			letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
		}
		return letterToCount;
	}
}
