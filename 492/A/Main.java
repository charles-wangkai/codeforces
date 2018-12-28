import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		int total = 0;
		int level = 0;
		for (int i = 1;; i++) {
			level += i;
			total += level;

			if (total > n) {
				return i - 1;
			}
		}
	}
}
