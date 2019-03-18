import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(i + 1)) {
				return String.format("YES\n%s", s.substring(i, i + 2));
			}
		}

		return "NO";
	}
}
