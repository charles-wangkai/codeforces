import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(solve(n, m));

		sc.close();
	}

	static int solve(int n, int m) {
		int socks = n;
		for (int day = 1;; day++) {
			if (socks == 0) {
				return day - 1;
			}

			if (day % m == 0) {
				socks++;
			}

			socks--;
		}
	}
}
