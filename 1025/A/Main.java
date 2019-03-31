import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(String s) {
		Map<Character, Integer> colorToCount = new HashMap<>();
		for (char color : s.toCharArray()) {
			colorToCount.put(color, colorToCount.getOrDefault(color, 0) + 1);
		}

		return s.length() == 1 || colorToCount.values().stream().anyMatch(count -> count != 1);
	}
}
