import java.util.Scanner;

public class Main {
	static final String[] SYMBOLS = { ".", "-.", "--" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String code = sc.next();
		System.out.println(solve(code));

		sc.close();
	}

	static String solve(String code) {
		StringBuilder result = new StringBuilder();
		int index = 0;
		while (index != code.length()) {
			for (int i = 0; i < SYMBOLS.length; i++) {
				if (code.startsWith(SYMBOLS[i], index)) {
					result.append(i);
					index += SYMBOLS[i].length();

					break;
				}
			}
		}
		return result.toString();
	}
}
