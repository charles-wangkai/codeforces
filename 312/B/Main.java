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

	static double solve(int a, int b, int c, int d) {
		double p1 = (double) a / b;
		double p2 = (double) c / d;

		return p1 / (1 - (1 - p1) * (1 - p2));
	}
}
