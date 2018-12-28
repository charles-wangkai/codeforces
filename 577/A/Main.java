import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		System.out.println(solve(n, x));

		sc.close();
	}

	static int solve(int n, int x) {
		int result = 0;
		for (int i = 1; i * i <= x && i <= n; i++) {
			if (x % i == 0) {
				int another = x / i;
				if (another <= n) {
					result++;

					if (another != i) {
						result++;
					}
				}
			}
		}
		return result;
	}
}
