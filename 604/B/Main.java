import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextInt();
		}
		System.out.println(solve(s, k));

		sc.close();
	}

	static int solve(int[] s, int k) {
		int result = -1;
		int lower = s[s.length - 1];
		int upper = s[s.length - 1] * 2;
		while (lower <= upper) {
			int middle = (lower + upper) / 2;

			if (computeBoxNum(s, middle) <= k) {
				result = middle;

				upper = middle - 1;
			} else {
				lower = middle + 1;
			}
		}

		return result;
	}

	static int computeBoxNum(int[] s, int boxSize) {
		int boxNum = 0;
		int freeCount = 0;
		int leftIndex = 0;
		int rightIndex = s.length - 1;
		while (leftIndex <= rightIndex) {
			while (leftIndex != rightIndex && s[leftIndex] + s[rightIndex] <= boxSize) {
				leftIndex++;
				freeCount++;
			}

			if (freeCount != 0) {
				freeCount--;
			}
			boxNum++;

			rightIndex--;
		}

		boxNum += (freeCount + 1) / 2;

		return boxNum;
	}
}
