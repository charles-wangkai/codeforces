import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] t = new int[n];
		for (int i = 0; i < t.length; i++) {
			t[i] = sc.nextInt();
		}
		System.out.println(solve(t, c));

		sc.close();
	}

	static int solve(int[] t, int c) {
		int result = 1;
		for (int i = 1; i < t.length; i++) {
			if (t[i] - t[i - 1] <= c) {
				result++;
			} else {
				result = 1;
			}
		}
		return result;
	}
}
