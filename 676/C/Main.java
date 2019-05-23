import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int k = sc.nextInt();
		String string = sc.next();
		System.out.println(solve(string, k));

		sc.close();
	}

	static int solve(String string, int k) {
		int n = string.length();

		List<Integer> lengths = buildLengths(string);

		return Math.max(computeMaxBeauty(n, lengths, k, 0), computeMaxBeauty(n, lengths, k, 1));
	}

	static List<Integer> buildLengths(String string) {
		List<Integer> lengths = new ArrayList<>();
		int length = -1;
		for (int i = 0; i <= string.length(); i++) {
			if (i >= 1 && i < string.length() && string.charAt(i) == string.charAt(i - 1)) {
				length++;
			} else {
				if (length >= 1) {
					lengths.add(length);
				}

				length = 1;
			}
		}
		return lengths;
	}

	static int computeMaxBeauty(int n, List<Integer> lengths, int k, int beginIndex) {
		int result = 0;
		int leftIndex = beginIndex;
		int targetNum = 0;
		int changeNum = 0;
		for (int i = beginIndex; i < lengths.size(); i += 2) {
			targetNum += lengths.get(i);

			if (i != beginIndex) {
				changeNum += lengths.get(i - 1);
			}

			while (changeNum > k) {
				targetNum -= lengths.get(leftIndex);
				changeNum -= lengths.get(leftIndex + 1);

				leftIndex += 2;
			}

			result = Math.max(result, Math.min(n, targetNum + k));
		}
		return result;
	}
}
