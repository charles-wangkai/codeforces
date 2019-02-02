import java.util.Scanner;

public class Main {
	static final String[] PARTS = { "144", "14", "1" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int n) {
		String s = String.valueOf(n);
		while (!s.isEmpty()) {
			boolean found = false;
			for (String part : PARTS) {
				if (s.startsWith(part)) {
					s = s.substring(part.length());

					found = true;
					break;
				}
			}

			if (!found) {
				return false;
			}
		}

		return true;
	}
}
