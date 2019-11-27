import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static final String TARGET = "bear";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		List<Integer> beginIndices = new ArrayList<>();
		int fromIndex = 0;
		while (true) {
			int beginIndex = s.indexOf(TARGET, fromIndex);
			if (beginIndex == -1) {
				break;
			}

			beginIndices.add(beginIndex);
			fromIndex = beginIndex + 1;
		}

		int result = computePairNum(s.length());
		int startIndex = 0;
		for (int i = 0; i < beginIndices.size(); i++) {
			result -= computePairNum(beginIndices.get(i) + TARGET.length() - 1 - startIndex)
					- computePairNum(TARGET.length() - 2);

			startIndex = beginIndices.get(i) + 1;
		}
		result -= computePairNum(s.length() - startIndex);

		return result;
	}

	static int computePairNum(int length) {
		return length * (length + 1) / 2;
	}
}
