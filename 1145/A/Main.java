import java.util.Scanner;

public class Main {
	static int maxSortedLength;

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

	static int solve(int[] a) {
		maxSortedLength = 0;
		checkSorted(a, 0, a.length - 1);

		return maxSortedLength;
	}

	static boolean checkSorted(int[] a, int beginIndex, int endIndex) {
		boolean result;
		if (beginIndex == endIndex) {
			result = true;
		} else {
			int middleIndex = (beginIndex + endIndex) / 2;
			boolean leftSorted = checkSorted(a, beginIndex, middleIndex);
			boolean rightSorted = checkSorted(a, middleIndex + 1, endIndex);

			result = leftSorted && rightSorted && a[middleIndex] <= a[middleIndex + 1];
		}

		if (result) {
			maxSortedLength = Math.max(maxSortedLength, endIndex - beginIndex + 1);
		}

		return result;
	}
}
