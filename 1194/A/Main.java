import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			int x = sc.nextInt();

			System.out.println(solve(n, x));
		}

		sc.close();
	}

	static int solve(int n, int x) {
		return x * 2;
	}
}
