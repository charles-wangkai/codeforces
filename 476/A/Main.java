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
		for (int i = (n + 1) / 2; i <= n; i++) {
			if (i % m == 0) {
				return i;
			}
		}
		return -1;
	}
}
