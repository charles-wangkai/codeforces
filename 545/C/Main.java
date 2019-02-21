import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		int[] h = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			h[i] = sc.nextInt();
		}
		System.out.println(solve(x, h));

		sc.close();
	}

	static int solve(int[] x, int[] h) {
		int n = x.length;

		int[] notFellRightMaxCuts = new int[n];
		int[] fellRightMaxCuts = new int[n];
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				notFellRightMaxCuts[i] = 1;
			} else {
				notFellRightMaxCuts[i] = Math.max(notFellRightMaxCuts[i - 1], fellRightMaxCuts[i - 1]);

				if (notFellRightMaxCuts[i] >= 0) {
					if (x[i] - h[i] > x[i - 1]) {
						notFellRightMaxCuts[i] = Math.max(notFellRightMaxCuts[i], notFellRightMaxCuts[i - 1] + 1);
					}

					if (x[i] - h[i] > x[i - 1] + h[i - 1]) {
						notFellRightMaxCuts[i] = Math.max(notFellRightMaxCuts[i], fellRightMaxCuts[i - 1] + 1);
					}
				}
			}

			if (i == 0) {
				if (i == n - 1 || x[i] + h[i] < x[i + 1]) {
					fellRightMaxCuts[i] = 1;
				} else {
					fellRightMaxCuts[i] = -1;
				}
			} else {
				if (i == n - 1 || x[i] + h[i] < x[i + 1]) {
					int prevMax = Math.max(notFellRightMaxCuts[i - 1], fellRightMaxCuts[i - 1]);

					if (prevMax >= 0) {
						fellRightMaxCuts[i] = prevMax + 1;
					} else {
						fellRightMaxCuts[i] = -1;
					}
				} else {
					fellRightMaxCuts[i] = -1;
				}
			}
		}

		return Math.max(notFellRightMaxCuts[n - 1], fellRightMaxCuts[n - 1]);
	}
}
