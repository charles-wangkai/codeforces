import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] d = new int[n];
		for (int i = 0; i < d.length; i++) {
			d[i] = sc.nextInt();
		}
		System.out.println(solve(d));

		sc.close();
	}

	static long solve(int[] d) {
		long result = 0;
		long leftSum = 0;
		long rightSum = 0;
		int leftIndex = -1;
		int rightIndex = d.length;
		while (leftIndex + 1 != rightIndex) {
			if (leftSum <= rightSum) {
				leftIndex++;
				leftSum += d[leftIndex];
			} else {
				rightIndex--;
				rightSum += d[rightIndex];
			}

			if (leftSum == rightSum) {
				result = Math.max(result, leftSum);
			}
		}
		return result;
	}
}
