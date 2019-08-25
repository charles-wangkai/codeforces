import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(solve(n, x, y));

		sc.close();
	}

	static int solve(int n, int x, int y) {
		return Math.max(0, divideToCeil(n * y, 100) - x);
	}

	static int divideToCeil(int a, int b) {
		return a / b + (a % b == 0 ? 0 : 1);
	}
}
