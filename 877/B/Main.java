import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		int n = s.length();

		int[] aPrefixCounts = new int[n + 1];
		int[] bPrefixCounts = new int[n + 1];
		int aPrefixCount = 0;
		int bPrefixCount = 0;
		for (int i = 1; i <= n; i++) {
			if (s.charAt(i - 1) == 'a') {
				aPrefixCount++;
			} else {
				bPrefixCount++;
			}

			aPrefixCounts[i] = aPrefixCount;
			bPrefixCounts[i] = bPrefixCount;
		}

		int result = 0;
		for (int endIndex1 = 0; endIndex1 <= n; endIndex1++) {
			for (int endIndex2 = endIndex1; endIndex2 <= n; endIndex2++) {
				result = Math.max(result,
						computeCount(aPrefixCounts, 0, endIndex1) + computeCount(bPrefixCounts, endIndex1, endIndex2)
								+ computeCount(aPrefixCounts, endIndex2, n));
			}
		}

		return result;
	}

	static int computeCount(int[] prefixCounts, int beginIndex, int endIndex) {
		return prefixCounts[endIndex] - prefixCounts[beginIndex];
	}
}
