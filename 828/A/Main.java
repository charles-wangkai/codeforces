import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int[] t = new int[n];
		for (int i = 0; i < t.length; i++) {
			t[i] = sc.nextInt();
		}
		System.out.println(solve(t, a, b));

		sc.close();
	}

	static int solve(int[] t, int a, int b) {
		int result = 0;
		int halfCount = 0;
		for (int ti : t) {
			if (ti == 1) {
				if (a != 0) {
					a--;
				} else if (b != 0) {
					b--;
					halfCount++;
				} else if (halfCount != 0) {
					halfCount--;
				} else {
					result++;
				}
			} else {
				if (b != 0) {
					b--;
				} else {
					result += 2;
				}
			}
		}

		return result;
	}
}
