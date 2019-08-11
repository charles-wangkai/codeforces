import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		if (n == 1) {
			return "-1";
		}

		return String.format("%d %d %d", n, n + 1, n * (n + 1));
	}
}
