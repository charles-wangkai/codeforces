
// https://blog.csdn.net/yutong5818/article/details/81319120

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		int[] nexts = buildNexts(s);

		List<Integer> candidateLengths = new ArrayList<>();
		int length = nexts[nexts.length - 1];
		while (length != 0) {
			candidateLengths.add(length);

			length = nexts[length - 1];
		}
		Collections.sort(candidateLengths);

		int resultIndex = -1;
		int lowerIndex = 0;
		int upperIndex = candidateLengths.size() - 1;
		while (lowerIndex <= upperIndex) {
			int middleIndex = (lowerIndex + upperIndex) / 2;

			if (kmp(s, 1, s.length() - 2, candidateLengths.get(middleIndex), nexts)) {
				resultIndex = middleIndex;

				lowerIndex = middleIndex + 1;
			} else {
				upperIndex = middleIndex - 1;
			}
		}

		return (resultIndex == -1) ? "Just a legend" : s.substring(0, candidateLengths.get(resultIndex));
	}

	static boolean kmp(String s, int textBeginIndex, int textEndIndex, int patternLength, int[] nexts) {
		int j = 0;
		for (int i = textBeginIndex; i <= textEndIndex; i++) {
			while (j > 0 && s.charAt(i) != s.charAt(j)) {
				j = nexts[j - 1];
			}

			if (s.charAt(i) == s.charAt(j)) {
				j++;
			}

			if (j == patternLength) {
				return true;
			}
		}

		return false;
	}

	static int[] buildNexts(String s) {
		int[] nexts = new int[s.length()];
		int k = 0;
		for (int i = 1; i < nexts.length; i++) {
			while (k > 0 && s.charAt(k) != s.charAt(i)) {
				k = nexts[k - 1];
			}

			if (s.charAt(k) == s.charAt(i)) {
				k++;
			}

			nexts[i] = k;
		}
		return nexts;
	}
}
