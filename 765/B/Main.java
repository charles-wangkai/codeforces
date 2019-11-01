import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();
		System.out.println(solve(S) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String S) {
		char next = 'a';
		for (char ch : S.toCharArray()) {
			if (ch > next) {
				return false;
			} else if (ch == next) {
				next++;
			}
		}

		return true;
	}
}
