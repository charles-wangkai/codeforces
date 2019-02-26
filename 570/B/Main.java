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
		if (n == 1) {
			return 1;
		}

		return ((m - 1) - 1 >= n - (m + 1)) ? (m - 1) : (m + 1);
	}
}
