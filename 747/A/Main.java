import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		int a = 1;
		int b = n;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				a = i;
				b = n / i;
			}
		}

		return String.format("%d %d", a, b);
	}
}
