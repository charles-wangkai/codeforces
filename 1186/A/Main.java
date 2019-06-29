import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n, m, k) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(int n, int m, int k) {
		return n <= Math.min(m, k);
	}
}
