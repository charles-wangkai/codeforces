import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int t = sc.nextInt();
		System.out.println(solve(n, k, t));

		sc.close();
	}

	static int solve(int n, int k, int t) {
		return Math.min(n, t) - Math.max(1, t - k + 1) + 1;
	}
}
