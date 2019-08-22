import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int p = sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s, p));

		sc.close();
	}

	static int solve(String s, int p) {
		int diffSum = 0;
		int minDiffIndex = Integer.MAX_VALUE;
		int maxDiffIndex = Integer.MIN_VALUE;
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			char ch1 = s.charAt(i);
			char ch2 = s.charAt(j);
			int diff = Math.min(Math.abs(ch1 - ch2), 26 - Math.abs(ch1 - ch2));

			if (diff != 0) {
				diffSum += diff;

				if (p * 2 <= s.length()) {
					minDiffIndex = Math.min(minDiffIndex, i);
					maxDiffIndex = Math.max(maxDiffIndex, i);
				} else {
					minDiffIndex = Math.min(minDiffIndex, j);
					maxDiffIndex = Math.max(maxDiffIndex, j);
				}
			}
		}

		return (diffSum == 0) ? 0
				: (diffSum + (maxDiffIndex - minDiffIndex)
						+ Math.min(Math.abs(p - 1 - minDiffIndex), Math.abs(p - 1 - maxDiffIndex)));
	}
}
