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
		Map<String, Integer> twoGramToCount = new HashMap<>();
		for (int i = 0; i < s.length() - 1; i++) {
			String twoGram = s.substring(i, i + 2);

			twoGramToCount.put(twoGram, twoGramToCount.getOrDefault(twoGram, 0) + 1);
		}

		int maxCount = twoGramToCount.values().stream().mapToInt(x -> x).max().getAsInt();
		return twoGramToCount.keySet().stream().filter(twoGram -> twoGramToCount.get(twoGram) == maxCount).findAny()
				.get();
	}
}
