import java.util.Scanner;

public class Main {
	static final String[] KEYBOARD = { "qwertyuiop", "asdfghjkl;", "zxcvbnm,./" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char direction = sc.next().charAt(0);
		String sequence = sc.next();
		System.out.println(solve(direction, sequence));

		sc.close();
	}

	static String solve(char direction, String sequence) {
		return sequence.chars().mapToObj(ch -> decode(direction, ch))
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}

	static char decode(char direction, int ch) {
		for (int i = 0;; i++) {
			int index = KEYBOARD[i].indexOf(ch);
			if (index >= 0) {
				if (direction == 'L') {
					return KEYBOARD[i].charAt(index + 1);
				} else {
					return KEYBOARD[i].charAt(index - 1);
				}
			}
		}
	}
}
