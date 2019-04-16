import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		StringBuilder result = new StringBuilder();
		for (char letter : s.toCharArray()) {
			if (!isVowel(letter) || result.length() == 0 || !isVowel(result.charAt(result.length() - 1))) {
				result.append(letter);
			}
		}
		return result.toString();
	}

	static boolean isVowel(char letter) {
		return "aeiouy".indexOf(letter) >= 0;
	}
}
