import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n, k));

		sc.close();
	}

	static int solve(int n, int k) {
		int remaining = 240 - k;
		int solveNum = 0;
		for (int i = 1; i <= n; i++) {
			int time = 5 * i;
			if (remaining < time) {
				break;
			}

			remaining -= time;
			solveNum++;
		}
		return solveNum;
	}
}
