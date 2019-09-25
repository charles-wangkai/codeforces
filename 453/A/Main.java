import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(solve(m, n));

		sc.close();
	}

	static double solve(int m, int n) {
		double result = 0;
		for (int i = 1; i <= m; i++) {
			double a1 = Math.pow((double) i / m, n - 1);
			double an = Math.pow((i - 1.0) / m, n - 1);
			double q = (i - 1.0) / i;
			double s = (a1 - an * q) / (1 - q);

			result += s * i / m;
		}

		return result;
	}
}
