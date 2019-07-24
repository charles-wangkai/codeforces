import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(solve(a, b, c) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(int a, int b, int c) {
		for (int i = 0; a * i <= c; i++) {
			if ((c - a * i) % b == 0) {
				return true;
			}
		}

		return false;
	}
}
