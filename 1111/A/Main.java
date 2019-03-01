import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String t = sc.next();
		System.out.println(solve(s, t) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(String s, String t) {
		return s.length() == t.length()
				&& IntStream.range(0, s.length()).allMatch(i -> isVowel(s.charAt(i)) == isVowel(t.charAt(i)));
	}

	static boolean isVowel(char letter) {
		return "aeiou".indexOf(letter) >= 0;
	}
}
