import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		int x = (n % 2 == 0) ? 4 : 9;
		int y = n - x;

		return String.format("%d %d", x, y);
	}
}
