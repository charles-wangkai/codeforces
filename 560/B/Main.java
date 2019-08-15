import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a1 = sc.nextInt();
		int b1 = sc.nextInt();
		int a2 = sc.nextInt();
		int b2 = sc.nextInt();
		int a3 = sc.nextInt();
		int b3 = sc.nextInt();
		System.out.println(solve(a1, b1, a2, b2, a3, b3) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int a1, int b1, int a2, int b2, int a3, int b3) {
		return check(a1, b1, a2, b2, a3, b3) || check(a1, b1, a2, b2, b3, a3) || check(a1, b1, b2, a2, a3, b3)
				|| check(a1, b1, b2, a2, b3, a3) || check(b1, a1, a2, b2, a3, b3) || check(b1, a1, a2, b2, b3, a3)
				|| check(b1, a1, b2, a2, a3, b3) || check(b1, a1, b2, a2, b3, a3);
	}

	static boolean check(int sumLimit, int maxLimit, int toSum1, int toMax1, int toSum2, int toMax2) {
		return toSum1 + toSum2 <= sumLimit && Math.max(toMax1, toMax2) <= maxLimit;
	}
}
