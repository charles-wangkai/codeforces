import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String t = sc.next();
		System.out.println(solve(s, t));

		sc.close();
	}

	static String solve(String s, String t) {
		int diffCount = (int) IntStream.range(0, s.length()).filter(i -> s.charAt(i) != t.charAt(i)).count();

		if (diffCount % 2 != 0) {
			return "impossible";
		}

		StringBuilder result = new StringBuilder();
		int flipCount = diffCount / 2;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i) && flipCount != 0) {
				result.append(t.charAt(i));
				flipCount--;
			} else {
				result.append(s.charAt(i));
			}
		}
		return result.toString();
	}
}
