import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int destX = sc.nextInt();
		int destY = sc.nextInt();
		System.out.println(solve(r, x, y, destX, destY));

		sc.close();
	}

	static int solve(int r, int x, int y, int destX, int destY) {
		int step = (int) Math.floor((Math.sqrt(square(x - destX) + square(y - destY)) / (2 * r)));
		while (square(2 * r * step) < square(x - destX) + square(y - destY)) {
			step++;
		}
		return step;
	}

	static long square(int n) {
		return (long) n * n;
	}
}
