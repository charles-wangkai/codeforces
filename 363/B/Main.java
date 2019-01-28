import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] h = new int[n];
		for (int i = 0; i < h.length; i++) {
			h[i] = sc.nextInt();
		}
		System.out.println(solve(h, k));

		sc.close();
	}

	static int solve(int[] h, int k) {
		int sum = IntStream.range(0, k).map(i -> h[i]).sum();
		int minSum = sum;
		int result = 1;
		for (int i = 1; i + k <= h.length; i++) {
			sum += h[i + k - 1] - h[i - 1];

			if (sum < minSum) {
				minSum = sum;
				result = i + 1;
			}
		}
		return result;
	}
}
