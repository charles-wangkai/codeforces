import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(a, b));

		sc.close();
	}

	static String solve(int a, int b) {
		int firstWinNum = 0;
		int drawNum = 0;
		int secondWinNum = 0;

		for (int dice = 1; dice <= 6; dice++) {
			int diffA = Math.abs(a - dice);
			int diffB = Math.abs(b - dice);

			if (diffA < diffB) {
				firstWinNum++;
			} else if (diffA > diffB) {
				secondWinNum++;
			} else {
				drawNum++;
			}
		}

		return String.format("%d %d %d", firstWinNum, drawNum, secondWinNum);
	}
}
