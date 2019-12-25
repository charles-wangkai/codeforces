import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		int result = 0;
		int depth = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				depth++;
			} else {
				if (depth != 0) {
					result += 2;
					depth--;
				}
			}
		}

		return result;
	}
}
