import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int n = sc.nextInt();

			System.out.println(solve(a, b, c, n) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int a, int b, int c, int n) {
		return (a + b + c + n) % 3 == 0 && (a + b + c + n) / 3 >= Math.max(Math.max(a, b), c);
	}
}
