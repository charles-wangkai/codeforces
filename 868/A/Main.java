import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String password = sc.next();
		int n = sc.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < words.length; i++) {
			words[i] = sc.next();
		}
		System.out.println(solve(password, words) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String password, String[] words) {
		return Arrays.stream(words).anyMatch(password::equals)
				|| (Arrays.stream(words).anyMatch(word -> word.charAt(1) == password.charAt(0))
						&& Arrays.stream(words).anyMatch(word -> word.charAt(0) == password.charAt(1)));
	}
}
