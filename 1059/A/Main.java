import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int L = sc.nextInt();
		int a = sc.nextInt();
		int[] t = new int[n];
		int[] l = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = sc.nextInt();
			l[i] = sc.nextInt();
		}
		System.out.println(solve(t, l, L, a));

		sc.close();
	}

	static int solve(int[] t, int[] l, int L, int a) {
		int result = 0;
		int prev = 0;
		for (int i = 0; i < t.length; i++) {
			result += (t[i] - prev) / a;

			prev = t[i] + l[i];
		}
		result += (L - prev) / a;
		return result;
	}
}
