import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String layout1 = sc.next();
		String layout2 = sc.next();
		String s = sc.next();
		System.out.println(solve(layout1, layout2, s));

		sc.close();
	}

	static String solve(String layout1, String layout2, String s) {
		Map<Character, Character> letter1ToLetter2 = new HashMap<>();
		for (int i = 0; i < layout1.length(); i++) {
			letter1ToLetter2.put(layout1.charAt(i), layout2.charAt(i));
			letter1ToLetter2.put(Character.toUpperCase(layout1.charAt(i)), Character.toUpperCase(layout2.charAt(i)));
		}

		return s.chars().mapToObj(letter1 -> letter1ToLetter2.getOrDefault((char) letter1, (char) letter1))
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}
}
