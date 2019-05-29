import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		int minSide = (int) Math.round(Math.sqrt(n));
		if (minSide * minSide > n) {
			minSide--;
		}

		if (minSide * minSide == n) {
			return minSide * 2;
		} else if (minSide * (minSide + 1) >= n) {
			return minSide * 2 + 1;
		} else {
			return minSide * 2 + 2;
		}
	}
}
