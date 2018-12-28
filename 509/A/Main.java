import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		return C(2 * (n - 1), n - 1);
	}

	static int C(int a, int b) {
		int result = 1;
		for (int i = 0; i < b; i++) {
			result = result * (a - i) / (i + 1);
		}
		return result;
	}
}
