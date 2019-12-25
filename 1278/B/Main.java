import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(solve(a, b));
		}

		sc.close();
	}

	static int solve(int a, int b) {
		int diff = Math.abs(a - b);

		int result = (int) Math.floor(Math.sqrt(diff * 2));
		while (result * (result + 1) / 2 < diff || (result * (result + 1) / 2 - diff) % 2 != 0) {
			result++;
		}

		return result;
	}
}
