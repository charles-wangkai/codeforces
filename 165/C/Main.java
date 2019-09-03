import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		String s = sc.next();
		System.out.println(solve(k, s));

		sc.close();
	}

	static long solve(int k, String s) {
		int[] oneIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == '1').toArray();

		if (k == 0) {
			if (oneIndices.length == 0) {
				return s.length() * (s.length() + 1L) / 2;
			} else {
				return IntStream.rangeClosed(0, oneIndices.length).mapToLong(i -> {
					int gap = (i == oneIndices.length ? s.length() : oneIndices[i]) - (i == 0 ? -1 : oneIndices[i - 1])
							- 1;

					return gap * (gap + 1L) / 2;
				}).sum();
			}
		}

		int[] leftZeroCounts = new int[s.length()];
		int leftZeroCount = 0;
		for (int i = 0; i < leftZeroCounts.length; i++) {
			if (s.charAt(i) == '0') {
				leftZeroCount++;
			} else {
				leftZeroCounts[i] = leftZeroCount;
				leftZeroCount = 0;
			}
		}

		int[] rightZeroCounts = new int[s.length()];
		int rightZeroCount = 0;
		for (int i = rightZeroCounts.length - 1; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				rightZeroCount++;
			} else {
				rightZeroCounts[i] = rightZeroCount;
				rightZeroCount = 0;
			}
		}

		return IntStream.rangeClosed(0, oneIndices.length - k)
				.mapToLong(i -> (leftZeroCounts[oneIndices[i]] + 1L) * (rightZeroCounts[oneIndices[i + k - 1]] + 1))
				.sum();
	}
}
