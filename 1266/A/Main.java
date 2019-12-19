import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int tc = 0; tc < n; tc++) {
			String y = sc.next();

			System.out.println(solve(y));
		}

		sc.close();
	}

	static String solve(String y) {
		return (y.indexOf('0') >= 0 && y.chars().filter(ch -> (ch - '0') % 2 == 0).count() >= 2
				&& y.chars().map(ch -> ch - '0').sum() % 3 == 0) ? "red" : "cyan";
	}
}
