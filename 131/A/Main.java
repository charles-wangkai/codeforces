import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.next();
		System.out.println(solve(word));

		sc.close();
	}

	static String solve(String word) {
		if (word.chars().skip(1).allMatch(Character::isUpperCase)) {
			char first = word.charAt(0);
			return (Character.isUpperCase(first) ? Character.toLowerCase(first) : Character.toUpperCase(first))
					+ word.substring(1).toLowerCase();
		} else {
			return word;
		}
	}
}
