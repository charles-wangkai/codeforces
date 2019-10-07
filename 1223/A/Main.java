import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();

			System.out.println(solve(n));
		}

		sc.close();
	}

	static int solve(int n) {
		if (n == 2) {
			return 2;
		} else if (n % 2 == 0) {
			return 0;
		} else {
			return 1;
		}
	}
}
