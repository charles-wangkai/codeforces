import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		int result = 0;
		int openIndex = -1;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch == '(') {
				result++;
				openIndex = i;
			} else if (ch == ')') {
				result++;

				if (openIndex != -1
						&& s.substring(openIndex + 1, i).chars().allMatch(c -> c == ' ' || Character.isLetter(c))) {
					result -= 2;
				}

				openIndex = -1;
			}
		}

		return result;
	}
}
