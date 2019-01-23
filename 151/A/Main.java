import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int l = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int p = sc.nextInt();
		int nl = sc.nextInt();
		int np = sc.nextInt();
		System.out.println(solve(n, k, l, c, d, p, nl, np));

		sc.close();
	}

	static int solve(int n, int k, int l, int c, int d, int p, int nl, int np) {
		return Math.min(Math.min(k * l / nl, c * d), p / np) / n;
	}
}
