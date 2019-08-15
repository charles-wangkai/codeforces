import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int pos = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		System.out.println(solve(n, pos, l, r));

		sc.close();
	}

	static int solve(int n, int pos, int l, int r) {
		if (l == 1 && r == n) {
			return 0;
		} else if (l == 1) {
			return Math.abs(pos - r) + 1;
		} else if (r == n) {
			return Math.abs(pos - l) + 1;
		} else {
			return Math.min(Math.abs(pos - l), Math.abs(pos - r)) + (r - l) + 2;
		}
	}
}
