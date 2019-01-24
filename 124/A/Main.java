import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(n, a, b));

		sc.close();
	}

	static int solve(int n, int a, int b) {
		return n - Math.max(a + 1, n - b) + 1;
	}
}
