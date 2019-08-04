import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n, k));

		sc.close();
	}

	static int solve(int n, int k) {
		int result = Integer.MAX_VALUE;
		for (int remainder = 1; remainder < k; remainder++) {
			if (n % remainder == 0) {
				result = Math.min(result, n / remainder * k + remainder);
			}
		}
		return result;
	}
}
