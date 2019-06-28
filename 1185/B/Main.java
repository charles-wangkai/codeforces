import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int tc = 0; tc < n; tc++) {
			String s = sc.next();
			String t = sc.next();

			System.out.println(solve(s, t) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(String s, String t) {
		int sIndex = 0;
		for (char tCh : t.toCharArray()) {
			if (sIndex < s.length() && tCh == s.charAt(sIndex)) {
				sIndex++;
			} else if (sIndex == 0 || tCh != s.charAt(sIndex - 1)) {
				return false;
			}
		}

		return sIndex == s.length();
	}
}
