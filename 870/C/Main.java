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
		int remainder = n % 4;

		if (remainder == 0) {
			return n / 4;
		} else if (remainder == 1) {
			if (n == 5) {
				return -1;
			} else {
				return (n - 9) / 4 + 1;
			}
		} else if (remainder == 2) {
			if (n == 2) {
				return -1;
			} else {
				return (n - 6) / 4 + 1;
			}
		} else {
			if (n <= 11) {
				return -1;
			} else {
				return (n - 15) / 4 + 2;
			}
		}
	}
}
