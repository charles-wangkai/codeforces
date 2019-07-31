import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n, k));

		sc.close();
	}

	static String solve(int n, int k) {
		int min = (k == 0 || k == n) ? 0 : 1;
		int max = Math.min(n - k, k * 2);

		return String.format("%d %d", min, max);
	}
}
