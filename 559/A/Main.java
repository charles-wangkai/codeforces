import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		int a3 = sc.nextInt();
		int a4 = sc.nextInt();
		int a5 = sc.nextInt();
		int a6 = sc.nextInt();
		System.out.println(solve(a1, a2, a3, a4, a5, a6));

		sc.close();
	}

	static int solve(int a1, int a2, int a3, int a4, int a5, int a6) {
		int result = 0;

		int upSide = a1;
		for (int i = 0; i < a2 + a3; i++) {
			int delta = 0;
			if (i < a2) {
				delta++;
			} else {
				delta--;
			}
			if (i < a6) {
				delta++;
			} else {
				delta--;
			}

			int downSide = upSide + delta / 2;

			result += computeTriangleNum(upSide, downSide);
			upSide = downSide;
		}

		return result;
	}

	static int computeTriangleNum(int upSide, int downSide) {
		return Math.min(upSide, downSide) * 2 + (upSide == downSide ? 0 : 1);
	}
}
