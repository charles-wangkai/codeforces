import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int k = sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s, k) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String s, int k) {
		Map<Character, Integer> colorToCount = new HashMap<>();
		for (char color : s.toCharArray()) {
			colorToCount.put(color, colorToCount.getOrDefault(color, 0) + 1);
		}

		return colorToCount.values().stream().allMatch(count -> count <= k);
	}
}
