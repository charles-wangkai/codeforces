import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int M = sc.nextInt();
		int[] t = new int[n];
		for (int i = 0; i < t.length; i++) {
			t[i] = sc.nextInt();
		}
		System.out.println(Arrays.stream(solve(t, M)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

		sc.close();
	}

	static int[] solve(int[] t, int M) {
		int[] result = new int[t.length];

		int prevSum = 0;
		for (int i = 0; i < result.length; i++) {
			if (i != 0) {
				prevSum += t[i - 1];
			}

			Arrays.sort(t, 0, i);

			int limit = M - t[i];
			int sum = prevSum;
			for (int j = i - 1;; j--) {
				if (sum <= limit) {
					result[i] = i - j - 1;

					break;
				}

				sum -= t[j];
			}
		}

		return result;
	}
}
