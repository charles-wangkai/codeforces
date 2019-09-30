import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		System.out.println(solve(n, d, e));

		sc.close();
	}

	static int solve(int n, int d, int e) {
		int result = n;
		for (int i = n; i >= 0; i -= 5 * e) {
			result = Math.min(result, i % d);
		}

		return result;
	}
}
