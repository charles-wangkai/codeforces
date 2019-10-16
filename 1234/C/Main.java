import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			sc.nextInt();
			String[] rows = new String[2];
			for (int i = 0; i < rows.length; i++) {
				rows[i] = sc.next();
			}

			System.out.println(solve(rows) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(String[] rows) {
		boolean verticalMove = false;
		int r = 0;
		int c = 0;

		while (c < rows[0].length()) {
			if (rows[r].charAt(c) <= '2') {
				if (verticalMove) {
					return false;
				}

				verticalMove = false;
				c++;
			} else {
				if (verticalMove) {
					verticalMove = false;
					c++;
				} else {
					verticalMove = true;
					r = 1 - r;
				}
			}
		}

		return r == 1;
	}
}
