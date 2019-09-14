import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.print(solve(x, y));

		sc.close();
	}

	static String solve(int x, int y) {
		int x1;
		int y1;
		int x2;
		int y2;
		if (x > 0) {
			if (y > 0) {
				x1 = 0;
				y1 = x + y;
				x2 = x + y;
				y2 = 0;
			} else {
				x1 = 0;
				y1 = -x + y;
				x2 = x - y;
				y2 = 0;
			}
		} else {
			if (y > 0) {
				x1 = x - y;
				y1 = 0;
				x2 = 0;
				y2 = -x + y;
			} else {
				x1 = x + y;
				y1 = 0;
				x2 = 0;
				y2 = x + y;
			}
		}

		return String.format("%d %d %d %d", x1, y1, x2, y2);
	}
}
