import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		int a3 = sc.nextInt();
		int b1 = sc.nextInt();
		int b2 = sc.nextInt();
		int b3 = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(solve(a1, a2, a3, b1, b2, b3, n) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int a1, int a2, int a3, int b1, int b2, int b3, int n) {
		return divideToCeil(a1 + a2 + a3, 5) + divideToCeil(b1 + b2 + b3, 10) <= n;
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
