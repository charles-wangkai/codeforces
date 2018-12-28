import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] m = new int[n];
		int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
			c[i] = sc.nextInt();
		}
		System.out.println(solve(m, c));

		sc.close();
	}

	static String solve(int[] m, int[] c) {
		int mWinRound = 0;
		int cWinRound = 0;
		for (int i = 0; i < m.length; i++) {
			if (m[i] > c[i]) {
				mWinRound++;
			} else if (m[i] < c[i]) {
				cWinRound++;
			}
		}

		if (mWinRound > cWinRound) {
			return "Mishka";
		} else if (mWinRound < cWinRound) {
			return "Chris";
		} else {
			return "Friendship is magic!^^";
		}
	}
}
