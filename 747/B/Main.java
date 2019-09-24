import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static final char[] TYPES = { 'A', 'C', 'G', 'T' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		Map<Character, Integer> letterToCount = new HashMap<>();
		for (char ch : s.toCharArray()) {
			if (ch != '?') {
				letterToCount.put(ch, letterToCount.getOrDefault(ch, 0) + 1);
			}
		}

		if (s.length() % 4 != 0 || letterToCount.values().stream().anyMatch(count -> count * 4 > s.length())) {
			return "===";
		}

		StringBuilder result = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (ch == '?') {
				for (char type : TYPES) {
					if (letterToCount.getOrDefault(type, 0) * 4 != s.length()) {
						result.append(type);
						letterToCount.put(type, letterToCount.getOrDefault(type, 0) + 1);

						break;
					}
				}
			} else {
				result.append(ch);
			}
		}

		return result.toString();
	}
}
