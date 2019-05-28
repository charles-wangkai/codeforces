import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(solve(x, y) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(int x, int y) {
		if (y == 0) {
			return false;
		}
		if (y == 1) {
			return x == 0;
		}

		x -= y - 1;
		return x >= 0 && x % 2 == 0;
	}
}
