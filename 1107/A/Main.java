import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			sc.nextInt();
			String s = sc.next();

			System.out.println(solve(s));
		}

		sc.close();
	}

	static String solve(String s) {
		if (s.length() == 2 && s.charAt(0) >= s.charAt(1)) {
			return "NO";
		} else {
			return String.format("YES\n2\n%c %s", s.charAt(0), s.substring(1));
		}
	}
}
