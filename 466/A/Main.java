import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(n, m, a, b));

		sc.close();
	}

	static int solve(int n, int m, int a, int b) {
		return Arrays.stream(new int[] { n * a, n / m * b + n % m * a, (n / m + 1) * b }).min().getAsInt();
	}
}
