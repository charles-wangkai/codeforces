import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int L = sc.nextInt();
			int v = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();

			System.out.println(solve(L, v, l, r));
		}

		sc.close();
	}

	static int solve(int L, int v, int l, int r) {
		return computeLanternNum(v, 1, L) - computeLanternNum(v, l, r);
	}

	static int computeLanternNum(int v, int left, int right) {
		int leftLanternIndex = left / v + (left % v == 0 ? 0 : 1);
		int rightLanternIndex = right / v;

		return rightLanternIndex - leftLanternIndex + 1;
	}
}
