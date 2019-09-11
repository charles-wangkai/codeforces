import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int n) {
		int root = (int) Math.floor(Math.sqrt(n * 2));

		return root * (root + 1) == n * 2;
	}
}
