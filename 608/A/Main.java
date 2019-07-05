import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] f = new int[n];
		int[] t = new int[n];
		for (int i = 0; i < n; i++) {
			f[i] = sc.nextInt();
			t[i] = sc.nextInt();
		}
		System.out.println(solve(f, t, s));

		sc.close();
	}

	static int solve(int[] f, int[] t, int s) {
		int[] maxTimes = new int[s + 1];
		for (int i = 0; i < f.length; i++) {
			maxTimes[f[i]] = Math.max(maxTimes[f[i]], t[i]);
		}

		int time = 0;
		for (int i = s; i > 0; i--) {
			time = Math.max(time, maxTimes[i]);

			time++;
		}
		return time;
	}
}
