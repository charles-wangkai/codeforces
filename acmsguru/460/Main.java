import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int tc = 0; tc < n; tc++) {
			String word = sc.next();

			System.out.println(solve(word));
		}

		sc.close();
	}

	static String solve(String word) {
		if (Arrays.asList("ch", "x", "s", "o").stream().anyMatch(word::endsWith)) {
			return String.format("%ses", word);
		}

		for (String suffix : new String[] { "f", "fe" }) {
			if (word.endsWith(suffix)) {
				return String.format("%sves", word.substring(0, word.length() - suffix.length()));
			}
		}

		if (word.endsWith("y")) {
			return String.format("%sies", word.substring(0, word.length() - 1));
		}

		return String.format("%ss", word);
	}
}
