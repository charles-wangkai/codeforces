import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		Map<Character, Integer> letterToCount = new HashMap<>();
		for (char letter : s.toCharArray()) {
			letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
		}

		StringBuilder result = new StringBuilder();
		for (char letter : letterToCount.keySet()) {
			for (int i = 0; i < letterToCount.get(letter); i++) {
				result.append(letter);
			}
		}
		return result.toString();
	}
}
