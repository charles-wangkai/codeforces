import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		System.out.println(solve(a, b, c, d));

		sc.close();
	}

	static String solve(int a, int b, int c, int d) {
		int mishaPoint = computePoint(a, c);
		int vasyaPoint = computePoint(b, d);

		if (mishaPoint < vasyaPoint) {
			return "Vasya";
		} else if (mishaPoint > vasyaPoint) {
			return "Misha";
		} else {
			return "Tie";
		}
	}

	static int computePoint(int p, int t) {
		return Math.max(3 * p / 10, p - p / 250 * t);
	}
}
