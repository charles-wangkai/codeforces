import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int k = sc.nextInt();
		System.out.println(solve(s, k));

		sc.close();
	}

	static String solve(String s, int k) {
		int questionCount = (int) s.chars().filter(ch -> ch == '?').count();
		int starCount = (int) s.chars().filter(ch -> ch == '*').count();

		int minLength = s.length() - (questionCount + starCount) * 2;

		if (k < minLength || (starCount == 0 && k > s.length() - questionCount)) {
			return "Impossible";
		}

		int diff = k - minLength;
		StringBuilder result = new StringBuilder();
		int index = 0;
		while (index != s.length()) {
			if (index + 1 < s.length() && s.charAt(index + 1) == '*') {
				while (diff != 0) {
					result.append(s.charAt(index));
					diff--;
				}

				index += 2;
			} else if (index + 1 < s.length() && s.charAt(index + 1) == '?') {
				if (diff != 0) {
					result.append(s.charAt(index));
					diff--;
				}

				index += 2;
			} else {
				result.append(s.charAt(index));

				index++;
			}
		}

		return result.toString();
	}
}
