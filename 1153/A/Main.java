import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();
		int[] s = new int[n];
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		System.out.println(solve(s, d, t));

		sc.close();
	}

	static int solve(int[] s, int[] d, int t) {
		int minTime = Integer.MAX_VALUE;
		int result = -1;
		for (int i = 0; i < s.length; i++) {
			int time = divideToCeil(t - s[i], d[i]) * d[i] + s[i];

			if (time < minTime) {
				minTime = time;
				result = i + 1;
			}
		}
		return result;
	}

	static int divideToCeil(int x, int y) {
		if (x < 0) {
			return 0;
		}

		return x / y + (x % y == 0 ? 0 : 1);
	}
}
