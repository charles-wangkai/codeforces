import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		System.out.println(solve(x1, y1, x2, y2));

		sc.close();
	}

	static String solve(int x1, int y1, int x2, int y2) {
		int x3;
		int y3;
		int x4;
		int y4;
		if (x1 == x2) {
			x3 = y1 - y2 + x1;
			y3 = y1;
			x4 = x3;
			y4 = y2;
		} else if (y1 == y2) {
			x3 = x1;
			y3 = x1 - x2 + y1;
			x4 = x2;
			y4 = y3;
		} else if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
			x3 = x1;
			y3 = y2;
			x4 = x2;
			y4 = y1;
		} else {
			return "-1";
		}

		return String.format("%d %d %d %d", x3, y3, x4, y4);
	}
}
