import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int n = sc.nextInt();
		int s = sc.nextInt();
		int p = sc.nextInt();
		System.out.println(solve(k, n, s, p));

		sc.close();
	}

	static int solve(int k, int n, int s, int p) {
		return divideToCeil(divideToCeil(n, s) * k, p);
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
