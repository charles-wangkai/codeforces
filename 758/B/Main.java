import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		Map<Character, Integer> colorToDeadCount = new HashMap<>();

		for (int i = 0; i < 4; i++) {
			int deadCount = 0;
			char color = 0;

			for (int j = i; j < s.length(); j += 4) {
				if (s.charAt(j) == '!') {
					deadCount++;
				} else {
					color = s.charAt(j);
				}
			}

			colorToDeadCount.put(color, deadCount);
		}

		return String.format("%d %d %d %d", colorToDeadCount.get('R'), colorToDeadCount.get('B'),
				colorToDeadCount.get('Y'), colorToDeadCount.get('G'));
	}
}
