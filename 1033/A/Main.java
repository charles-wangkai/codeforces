import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int ax = sc.nextInt();
		int ay = sc.nextInt();
		int bx = sc.nextInt();
		int by = sc.nextInt();
		int cx = sc.nextInt();
		int cy = sc.nextInt();
		System.out.println(solve(n, ax, ay, bx, by, cx, cy) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int n, int ax, int ay, int bx, int by, int cx, int cy) {
		return computeQuadrant(ax, ay, bx, by) == computeQuadrant(ax, ay, cx, cy);
	}

	static int computeQuadrant(int ax, int ay, int x, int y) {
		if (x > ax) {
			if (y > ay) {
				return 1;
			} else {
				return 4;
			}
		} else {
			if (y > ay) {
				return 2;
			} else {
				return 3;
			}
		}
	}
}
