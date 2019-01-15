import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static long solve(int[] a) {
		long sum = Arrays.stream(a).asLongStream().sum();
		if (sum % 3 != 0) {
			return 0;
		}
		long partSum = sum / 3;

		Map<Long, Integer> rightSumToCount = new HashMap<>();
		long rightSum = 0;
		for (int i = a.length - 1; i >= 2; i--) {
			rightSum += a[i];
			rightSumToCount.put(rightSum, rightSumToCount.getOrDefault(rightSum, 0) + 1);
		}

		long result = 0;
		long leftSum = 0;
		for (int i = 0; i <= a.length - 3; i++) {
			leftSum += a[i];
			if (leftSum == partSum) {
				result += rightSumToCount.getOrDefault(partSum, 0);
			}

			rightSumToCount.put(rightSum, rightSumToCount.get(rightSum) - 1);
			rightSum -= a[i + 2];
		}
		return result;
	}
}
