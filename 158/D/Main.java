import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] t = new int[n];
		for (int i = 0; i < t.length; i++) {
			t[i] = sc.nextInt();
		}
		System.out.println(solve(t));

		sc.close();
	}

	static int solve(int[] t) {
		int result = Integer.MIN_VALUE;

		for (int i = 1; i * i <= t.length; i++) {
			if (t.length % i == 0) {
				for (int distance : new int[] { i, t.length / i }) {
					if (t.length / distance >= 3) {
						result = Math.max(result, computeMaxSum(t, distance));
					}
				}
			}
		}

		return result;
	}

	static int computeMaxSum(int[] t, int distance) {
		int result = Integer.MIN_VALUE;
		for (int beginIndex = 0; beginIndex < distance; beginIndex++) {
			int sum = 0;
			for (int i = beginIndex; i < t.length; i += distance) {
				sum += t[i];
			}

			result = Math.max(result, sum);
		}

		return result;
	}
}
