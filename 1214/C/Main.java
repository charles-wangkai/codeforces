import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(String s) {
		int depth = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				depth++;
			} else {
				depth--;

				if (depth < -1) {
					return false;
				}
			}
		}

		return depth == 0;
	}
}
