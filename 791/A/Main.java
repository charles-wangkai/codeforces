import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(a, b));

		sc.close();
	}

	static int solve(int a, int b) {
		for (int year = 1;; year++) {
			a *= 3;
			b *= 2;

			if (a > b) {
				return year;
			}
		}
	}
}
