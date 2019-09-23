import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		int t = sc.nextInt();
		int d = sc.nextInt();
		System.out.println(solve(v1, v2, t, d));

		sc.close();
	}

	static int solve(int v1, int v2, int t, int d) {
		int[] leftMins = new int[t];
		int leftMin = v1;
		for (int i = 0; i < leftMins.length; i++) {
			leftMins[i] = leftMin;
			leftMin += d;
		}

		int[] rightMins = new int[t];
		int rightMin = v2;
		for (int i = rightMins.length - 1; i >= 0; i--) {
			rightMins[i] = rightMin;
			rightMin += d;
		}

		return IntStream.range(0, t).map(i -> Math.min(leftMins[i], rightMins[i])).sum();
	}
}
