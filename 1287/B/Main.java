import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	static final char[] VALUES = { 'S', 'E', 'T' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextInt();
		String[] cards = new String[n];
		for (int i = 0; i < cards.length; ++i) {
			cards[i] = sc.next();
		}
		System.out.println(solve(cards));

		sc.close();
	}

	static int solve(String[] cards) {
		Set<String> cardSet = Arrays.stream(cards).collect(Collectors.toSet());

		int result = 0;
		for (int i = 0; i < cards.length; ++i) {
			for (int j = i + 1; j < cards.length; ++j) {
				if (cardSet.contains(computeTarget(cards[i], cards[j]))) {
					++result;
				}
			}
		}
		result /= 3;

		return result;
	}

	static String computeTarget(String card1, String card2) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < card1.length(); ++i) {
			char ch1 = card1.charAt(i);
			char ch2 = card2.charAt(i);

			char ch;
			if (ch1 == ch2) {
				ch = ch1;
			} else {
				for (int j = 0;; ++j) {
					if (VALUES[j] != ch1 && VALUES[j] != ch2) {
						ch = VALUES[j];

						break;
					}
				}
			}
			result.append(ch);
		}

		return result.toString();
	}
}
