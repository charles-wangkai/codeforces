import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int str = sc.nextInt();
			int itl = sc.nextInt();
			int exp = sc.nextInt();

			System.out.println(solve(str, itl, exp));
		}

		sc.close();
	}

	static int solve(int str, int itl, int exp) {
		return Math.max(0, (str + exp) - Math.max(str, (str + itl + exp + 2) / 2) + 1);
	}
}
