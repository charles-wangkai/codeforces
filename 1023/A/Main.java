import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		sc.nextInt();
		String s = sc.next();
		String t = sc.next();
		System.out.println(solve(s, t) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String s, String t) {
		int wildcardIndex = s.indexOf('*');

		if (wildcardIndex == -1) {
			return s.equals(t);
		} else {
			return s.length() - 1 <= t.length() && t.startsWith(s.substring(0, wildcardIndex))
					&& t.endsWith(s.substring(wildcardIndex + 1));
		}
	}
}
