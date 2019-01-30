import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int y = sc.nextInt();
		int b = sc.nextInt();
		int r = sc.nextInt();
		System.out.println(solve(y, b, r));

		sc.close();
	}

	static int solve(int y, int b, int r) {
		return Math.min(Math.min(y + 1, b), r - 1) * 3;
	}
}
