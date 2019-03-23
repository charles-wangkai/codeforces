import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String s) {
		return IntStream.range(0, s.length()).allMatch(
				i -> isVowel(s.charAt(i)) || s.charAt(i) == 'n' || (i + 1 < s.length() && isVowel(s.charAt(i + 1))));
	}

	static boolean isVowel(char letter) {
		return "aeiou".indexOf(letter) >= 0;
	}
}
