import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int d = sc.nextInt();
		int sumTime = sc.nextInt();
		int[] minTimes = new int[d];
		int[] maxTimes = new int[d];
		for (int i = 0; i < d; i++) {
			minTimes[i] = sc.nextInt();
			maxTimes[i] = sc.nextInt();
		}
		System.out.println(solve(minTimes, maxTimes, sumTime));

		sc.close();
	}

	static String solve(int[] minTimes, int[] maxTimes, int sumTime) {
		int minSumTime = Arrays.stream(minTimes).sum();
		int maxSumTime = Arrays.stream(maxTimes).sum();

		if (sumTime >= minSumTime && sumTime <= maxSumTime) {
			int[] times = minTimes.clone();
			int sum = Arrays.stream(times).sum();
			for (int i = 0; i < times.length; i++) {
				int addition = Math.min(sumTime - sum, maxTimes[i] - times[i]);

				times[i] += addition;
				sum += addition;
			}

			return String.format("YES\n%s",
					String.join(" ", Arrays.stream(times).mapToObj(String::valueOf).toArray(String[]::new)));
		} else {
			return "NO";
		}
	}
}
