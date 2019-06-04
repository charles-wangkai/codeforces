import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(solve(a, b, c));

		sc.close();
	}

	static long solve(int a, int b, int c) {
		return c * 2L + ((a <= b) ? (a + Math.min(b, a + 1)) : (b + Math.min(a, b + 1)));
	}
}
