import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int v = sc.nextInt();
		System.out.println(solve(n, v));

		sc.close();
	}

	static int solve(int n, int v) {
		if (n - 1 <= v) {
			return n - 1;
		}

		int result = v;
		for (int i = 0; i < n - 1 - v; i++) {
			result += i + 2;
		}
		return result;
	}
}
