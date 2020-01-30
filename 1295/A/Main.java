import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int n = sc.nextInt();

			System.out.println(solve(n));
		}

		sc.close();
	}

	static String solve(int n) {
		StringBuilder result = new StringBuilder();
		if (n % 2 != 0) {
			result.append(7);
			n -= 3;
		}
		while (n != 0) {

			result.append(1);
			n -= 2;
		}

		return result.toString();
	}
}
