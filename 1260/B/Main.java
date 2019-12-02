import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(solve(a, b) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int a, int b) {
		return a <= b * 2 && b <= a * 2 && (a + b) % 3 == 0;
	}
}
