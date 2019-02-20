import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(solve(a, b, c) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int a, int b, int c) {
		if (c == 0) {
			return a == b;
		} else {
			return (b - a) % c == 0 && (b - a) / c >= 0;
		}
	}
}
