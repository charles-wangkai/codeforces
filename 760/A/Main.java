import java.util.Scanner;

public class Main {
	static final int[] MONTH_DAYS = { -1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int d = sc.nextInt();
		System.out.println(solve(m, d));

		sc.close();
	}

	static int solve(int m, int d) {
		return 1 + divideToCeil(MONTH_DAYS[m] - (8 - d), 7);
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
