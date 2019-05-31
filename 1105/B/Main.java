import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int k = sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s, k));

		sc.close();
	}

	static int solve(String s, int k) {
		Map<Character, Integer> letterToLevel = new HashMap<>();
		int count = -1;
		for (int i = 0; i <= s.length(); i++) {
			if (i != 0 && i != s.length() && s.charAt(i) == s.charAt(i - 1)) {
				count++;
			} else {
				if (i != 0) {
					char letter = s.charAt(i - 1);
					letterToLevel.put(letter, letterToLevel.getOrDefault(letter, 0) + count / k);
				}

				count = 1;
			}
		}

		return letterToLevel.values().stream().mapToInt(x -> x).max().getAsInt();
	}
}
