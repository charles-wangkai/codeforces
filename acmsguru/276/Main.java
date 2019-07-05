import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int S = sc.nextInt();
		int P = sc.nextInt();
		System.out.println(solve(S, P));

		sc.close();
	}

	static int solve(int S, int P) {
		int lateSecond = P - S;

		if (lateSecond >= 30 * 60) {
			return 4;
		} else if (lateSecond >= 15 * 60) {
			return 3;
		} else if (lateSecond >= 5 * 60) {
			return 2;
		} else if (lateSecond > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
