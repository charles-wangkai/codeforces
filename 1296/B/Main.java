import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int s = sc.nextInt();

			System.out.println(solve(s));
		}

		sc.close();
	}

	static int solve(int s) {
		int result = 0;
		while (s >= 10) {
			result += s / 10 * 10;
			s = s % 10 + s / 10;
		}
		result += s;

		return result;
	}
}
