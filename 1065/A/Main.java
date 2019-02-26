import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int s = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			System.out.println(solve(s, a, b, c));
		}

		sc.close();
	}

	static long solve(int s, int a, int b, int c) {
		return s / ((long) a * c) * (a + b) + s % ((long) a * c) / c;
	}
}
