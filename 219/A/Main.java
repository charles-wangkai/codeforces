import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		String s = sc.next();
		System.out.println(solve(k, s));

		sc.close();
	}

	static String solve(int k, String s) {
		Map<Character, Integer> letterToCount = new HashMap<>();
		for (char letter : s.toCharArray()) {
			letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
		}

		if (letterToCount.values().stream().anyMatch(count -> count % k != 0)) {
			return "-1";
		}

		StringBuilder part = new StringBuilder();
		for (char letter : letterToCount.keySet()) {
			part.append(repeat(String.valueOf(letter), letterToCount.get(letter) / k));
		}

		return repeat(part.toString(), k);
	}

	static String repeat(String s, int count) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < count; i++) {
			result.append(s);
		}
		return result.toString();
	}
}
