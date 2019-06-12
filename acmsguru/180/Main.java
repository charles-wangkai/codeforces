import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
		System.out.println(solve(A));

		sc.close();
	}

	static long solve(int[] A) {
		return computeInversionNum(A, 0, A.length - 1);
	}

	static long computeInversionNum(int[] A, int beginIndex, int endIndex) {
		if (beginIndex == endIndex) {
			return 0;
		}

		int middleIndex = (beginIndex + endIndex) / 2;

		long result = computeInversionNum(A, beginIndex, middleIndex)
				+ computeInversionNum(A, middleIndex + 1, endIndex);

		int[] leftSorted = Arrays.copyOfRange(A, beginIndex, middleIndex + 1);
		int[] rightSorted = Arrays.copyOfRange(A, middleIndex + 1, endIndex + 1);
		int leftIndex = 0;
		int rightIndex = 0;
		for (int i = beginIndex; i <= endIndex; i++) {
			if (leftIndex < leftSorted.length
					&& (rightIndex == rightSorted.length || leftSorted[leftIndex] <= rightSorted[rightIndex])) {
				A[i] = leftSorted[leftIndex];
				leftIndex++;
			} else {
				result += leftSorted.length - leftIndex;

				A[i] = rightSorted[rightIndex];
				rightIndex++;
			}
		}

		return result;
	}
}
