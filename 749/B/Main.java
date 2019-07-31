import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x0 = sc.nextInt();
		int y0 = sc.nextInt();
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		System.out.println(solve(x0, y0, x1, y1, x2, y2));

		sc.close();
	}

	static String solve(int x0, int y0, int x1, int y1, int x2, int y2) {
		return String.format("3\n%d %d\n%d %d\n%d %d", x0 + x1 - x2, y0 + y1 - y2, x0 - x1 + x2, y0 - y1 + y2,
				-x0 + x1 + x2, -y0 + y1 + y2);
	}
}
