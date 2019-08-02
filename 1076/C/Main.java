import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int d = sc.nextInt();

			System.out.println(solve(d));
		}

		sc.close();
	}

	static String solve(int d) {
		if (d > 0 && d < 4) {
			return "N";
		}

		double a = (d - Math.sqrt(d * d - 4 * d)) / 2;
		double b = d - a;

		return String.format("Y %.10f %.10f", a, b);
	}
}
