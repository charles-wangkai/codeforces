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
		if (word.length() > 10) {
			return String.format("%c%d%c", word.charAt(0), word.length() - 2, word.charAt(word.length() - 1));
		} else {
			return word;
		}
	}
}
