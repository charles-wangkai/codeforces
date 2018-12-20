import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String guest = sc.next();
		String host = sc.next();
		String letters = sc.next();
		System.out.println(solve(guest, host, letters) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String guest, String host, String letters) {
		return buildLetterToCount(guest + host).equals(buildLetterToCount(letters));
	}

	static Map<Character, Integer> buildLetterToCount(String s) {
		Map<Character, Integer> letterToCount = new HashMap<>();
		for (char letter : s.toCharArray()) {
			letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
		}
		return letterToCount;
	}
}
