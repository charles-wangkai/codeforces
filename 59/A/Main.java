import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		if (s.chars().filter(Character::isUpperCase).count() > s.chars().filter(Character::isLowerCase).count()) {
			return s.toUpperCase();
		} else {
			return s.toLowerCase();
		}
	}
}
