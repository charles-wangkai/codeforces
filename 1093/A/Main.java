import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int x = sc.nextInt();

			System.out.println(solve(x));
		}

		sc.close();
	}

	static int solve(int x) {
		return x / 7 + (x % 7 == 0 ? 0 : 1);
	}
}
