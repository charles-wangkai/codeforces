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
		Map<Character, Integer> sLetterToCount = buildLetterToCount(s);
		Map<Character, Integer> tLetterToCount = buildLetterToCount(t);

		int exactCount = 0;
		int diffCaseCount = 0;
		for (char letter : sLetterToCount.keySet()) {
			int d = Math.min(sLetterToCount.get(letter), tLetterToCount.getOrDefault(letter, 0));
			exactCount += d;
			updateMap(sLetterToCount, letter, -d);
			updateMap(tLetterToCount, letter, -d);
		}

		for (char letter : sLetterToCount.keySet()) {
			char otherLetter = computeOtherLetter(letter);
			int d = Math.min(sLetterToCount.get(letter), tLetterToCount.getOrDefault(otherLetter, 0));
			diffCaseCount += d;
			updateMap(sLetterToCount, letter, -d);
			updateMap(tLetterToCount, otherLetter, -d);
		}

		return String.format("%d %d", exactCount, diffCaseCount);
	}

	static Map<Character, Integer> buildLetterToCount(String str) {
		Map<Character, Integer> letterToCount = new HashMap<>();
		for (char letter : str.toCharArray()) {
			letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
		}

		return letterToCount;
	}

	static void updateMap(Map<Character, Integer> letterToCount, char letter, int countDelta) {
		letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + countDelta);
	}

	static char computeOtherLetter(char letter) {
		return Character.isLowerCase(letter) ? Character.toUpperCase(letter) : Character.toLowerCase(letter);
	}
}
