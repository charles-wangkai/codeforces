import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		if (n <= 3) {
			return "NO";
		}

		List<String> operations = new ArrayList<>();
		if (n == 4) {
			operations.add("1 * 2 = 2");
			operations.add("2 * 3 = 6");
			operations.add("6 * 4 = 24");
		} else if (n == 5) {
			operations.add("4 * 5 = 20");
			operations.add("3 - 1 = 2");
			operations.add("2 * 2 = 4");
			operations.add("20 + 4 = 24");
		} else {
			operations.add("1 + 5 = 6");
			operations.add("6 - 6 = 0");

			for (int i = 7; i <= n; i++) {
				operations.add(String.format("0 * %d = 0", i));
			}

			operations.add("2 * 3 = 6");
			operations.add("6 * 4 = 24");
			operations.add("24 + 0 = 24");
		}

		return String.format("YES\n%s", String.join("\n", operations));
	}
}
