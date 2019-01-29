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
		int modDivisor = 1;
		for (int i = 0; i < n && modDivisor <= m; i++) {
			modDivisor *= 2;
		}

		return m % modDivisor;
	}
}
