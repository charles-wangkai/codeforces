import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int k = sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s, k));

		sc.close();
	}

	static String solve(String s, int k) {
		StringBuilder result = new StringBuilder();
		int skipCount = (s.length() - k) / 2;
		int depth = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				if (skipCount == 0) {
					result.append(ch);
					depth++;
				} else {
					skipCount--;
				}
			} else {
				if (depth != 0) {
					result.append(ch);
					depth--;
				}
			}
		}

		return result.toString();
	}
}
