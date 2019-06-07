import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int x = sc.nextInt();
		int b = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(solve(n, a, x, b, y) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int n, int a, int x, int b, int y) {
		while (a != x && b != y) {
			a++;
			if (a == n + 1) {
				a = 1;
			}

			b--;
			if (b == 0) {
				b = n;
			}

			if (a == b) {
				return true;
			}
		}
		return false;
	}
}
