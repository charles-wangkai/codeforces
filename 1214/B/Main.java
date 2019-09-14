import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int b = sc.nextInt();
		int g = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(solve(b, g, n));

		sc.close();
	}

	static int solve(int b, int g, int n) {
		return Math.min(b, n) - Math.max(0, n - g) + 1;
	}
}
