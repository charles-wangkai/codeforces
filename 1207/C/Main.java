import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			String s = sc.next();

			System.out.println(solve(s, a, b));
		}

		sc.close();
	}

	static long solve(String s, int a, int b) {
		int n = s.length();

		int[] heights = IntStream.range(0, n + 1).map(i -> 1).toArray();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				heights[i] = 2;
				heights[i + 1] = 2;
			}
		}

		int beginIndex = -1;
		for (int i = 0; i < heights.length; i++) {
			if (heights[i] == 2) {
				if (beginIndex != -1) {
					int endIndex = i - 1;
					int length = endIndex - beginIndex + 1;

					if ((long) length * b < 2 * a) {
						for (int j = beginIndex; j <= endIndex; j++) {
							heights[j] = 2;
						}
					}
				}

				beginIndex = i + 1;
			}
		}

		return (n + IntStream.range(0, heights.length - 1).filter(i -> heights[i] != heights[i + 1]).count()) * a
				+ (long) Arrays.stream(heights).sum() * b;
	}
}
