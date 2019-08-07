import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		int result = 1;
		for (int k = 2;; k++) {
			int number = ((1 << k) - 1) * (1 << (k - 1));
			if (number > n) {
				break;
			}

			if (n % number == 0) {
				result = number;
			}
		}

		return result;
	}
}
