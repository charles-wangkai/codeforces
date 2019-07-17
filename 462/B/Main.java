import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int k = sc.nextInt();
		String cards = sc.next();
		System.out.println(solve(cards, k));

		sc.close();
	}

	static long solve(String cards, int k) {
		Map<Character, Integer> cardToCount = new HashMap<>();
		for (char card : cards.toCharArray()) {
			cardToCount.put(card, cardToCount.getOrDefault(card, 0) + 1);
		}

		long result = 0;
		List<Integer> sortedCounts = cardToCount.values().stream()
				.sorted((count1, count2) -> Integer.compare(count2, count1)).collect(Collectors.toList());
		for (int count : sortedCounts) {
			int size = Math.min(count, k);
			k -= size;

			result += (long) size * size;
		}
		return result;
	}
}
