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
		int b = (n % 3 == 2) ? 2 : 1;
		int c = n - a - b;

		return String.format("%d %d %d", a, b, c);
	}
}
