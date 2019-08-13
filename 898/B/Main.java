import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.print(solve(n, a, b));

		sc.close();
	}

	static String solve(int n, int a, int b) {
		for (int x = 0; x * a <= n; x++) {
			if ((n - x * a) % b == 0) {
				return String.format("YES\n%d %d", x, (n - x * a) / b);
			}
		}

		return "NO";
	}
}
