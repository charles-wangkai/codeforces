import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int JOKE_TIME = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();
		int[] t = new int[n];
		for (int i = 0; i < t.length; i++) {
			t[i] = sc.nextInt();
		}
		System.out.println(solve(t, d));

		sc.close();
	}

	static int solve(int[] t, int d) {
		int required = Arrays.stream(t).sum() + (t.length - 1) * JOKE_TIME * 2;
		if (required > d) {
			return -1;
		}

		return (t.length - 1) * 2 + (d - required) / JOKE_TIME;
	}
}
