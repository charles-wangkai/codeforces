import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] L = new int[n];
		for (int i = 0; i < L.length; i++) {
			L[i] = sc.nextInt();
		}
		System.out.println(solve(L));

		sc.close();
	}

	static int solve(int[] L) {
		int result = 0;
		int minKilled = Integer.MAX_VALUE;
		for (int i = L.length - 1; i >= 0; i--) {
			if (i < minKilled) {
				result++;
			}

			minKilled = Math.min(minKilled, i - L[i]);
		}

		return result;
	}
}
