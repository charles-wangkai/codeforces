import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(solve(n, a, b, c));

		sc.close();
	}

	static int solve(int n, int a, int b, int c) {
		return ((n >= 2) ? 1 : 0) * Math.min(a, b) + Math.max(0, n - 2) * Math.min(Math.min(a, b), c);
	}
}
