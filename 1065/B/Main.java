import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long m = sc.nextLong();
		System.out.println(solve(n, m));

		sc.close();
	}

	static String solve(int n, long m) {
		int min = (int) Math.max(0, n - m * 2);

		int max = n;
		while ((long) (n - max) * (n - max - 1) / 2 < m) {
			max--;
		}

		return String.format("%d %d", min, max);
	}
}
