import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int r = sc.nextInt();
			int g = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(solve(r, g, b) ? "Yes" : "No");
		}

		sc.close();
	}

	static boolean solve(int r, int g, int b) {
		int max = Math.max(Math.max(r, g), b);

		return (long) r + g + b - max >= max - 1;
	}
}
