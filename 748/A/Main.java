import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n, m, k));

		sc.close();
	}

	static String solve(int n, int m, int k) {
		return String.format("%d %d %c", (k - 1) / (2 * m) + 1, (k - 1) / 2 % m + 1, (k % 2 == 1) ? 'L' : 'R');
	}
}
