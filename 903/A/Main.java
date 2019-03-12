import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int tc = 0; tc < n; tc++) {
			int x = sc.nextInt();

			System.out.println(solve(x) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int x) {
		for (int i = 0; i <= x; i += 3) {
			if ((x - i) % 7 == 0) {
				return true;
			}
		}
		return false;
	}
}
