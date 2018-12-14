import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int n = sc.nextInt();
		int w = sc.nextInt();
		System.out.println(solve(k, n, w));

		sc.close();
	}

	static int solve(int k, int n, int w) {
		return Math.max(0, w * (w + 1) / 2 * k - n);
	}
}
