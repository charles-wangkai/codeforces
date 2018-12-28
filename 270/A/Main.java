import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int a = sc.nextInt();

			System.out.println(solve(a) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int a) {
		return 360 % (180 - a) == 0;
	}
}
