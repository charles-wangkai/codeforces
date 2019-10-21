import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			System.out.println(solve(a, b, c));
		}

		sc.close();
	}

	static int solve(int a, int b, int c) {
		int result = 0;
		while (b >= 1 && c >= 2) {
			b--;
			c -= 2;
			result += 3;
		}
		while (a >= 1 && b >= 2) {
			a--;
			b -= 2;
			result += 3;
		}

		return result;
	}
}
