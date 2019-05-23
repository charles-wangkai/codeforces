import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] names = new String[n];
		for (int i = 0; i < names.length; i++) {
			names[i] = sc.next();
		}
		System.out.println(solve(names));

		sc.close();
	}

	static int solve(String[] names) {
		Map<Character, Integer> firstLetterToCount = new HashMap<>();
		for (String name : names) {
			char firstLetter = name.charAt(0);

			firstLetterToCount.put(firstLetter, firstLetterToCount.getOrDefault(firstLetter, 0) + 1);
		}

		return firstLetterToCount.values().stream()
				.mapToInt(count -> computePairNum(count / 2) + computePairNum(count - count / 2)).sum();
	}

	static int computePairNum(int x) {
		return x * (x - 1) / 2;
	}
}
