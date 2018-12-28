import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] rows = new String[n];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = sc.next();
		}
		System.out.println(solve(rows));

		sc.close();
	}

	static String solve(String[] rows) {
		for (int i = 0; i < rows.length; i++) {
			if (rows[i].contains("OO")) {
				rows[i] = rows[i].replaceFirst("OO", "++");

				return String.format("YES\n%s", String.join("\n", rows));
			}
		}

		return "NO";
	}
}
