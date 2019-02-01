import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String n = sc.next();
		System.out.print(solve(n));

		sc.close();
	}

	static String solve(String n) {
		for (int i = 0; i < n.length(); i++) {
			int number = n.charAt(i) - '0';

			if (number % 8 == 0) {
				return buildYesOutput(number);
			}
		}

		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) != '0') {
				for (int j = i + 1; j < n.length(); j++) {
					int number = (n.charAt(i) - '0') * 10 + (n.charAt(j) - '0');

					if (number % 8 == 0) {
						return buildYesOutput(number);
					}
				}
			}
		}

		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) != '0') {
				for (int j = i + 1; j < n.length(); j++) {
					for (int k = j + 1; k < n.length(); k++) {
						int number = (n.charAt(i) - '0') * 100 + (n.charAt(j) - '0') * 10 + (n.charAt(k) - '0');

						if (number % 8 == 0) {
							return buildYesOutput(number);
						}
					}
				}
			}
		}

		return "NO";
	}

	static String buildYesOutput(int number) {
		return String.format("YES\n%d", number);
	}
}
