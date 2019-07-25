import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int SIZE = 26;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		int m = sc.nextInt();
		String[] t = new String[m];
		for (int i = 0; i < t.length; i++) {
			t[i] = sc.next();
		}
		Arrays.stream(solve(s, t)).forEach(System.out::println);

		sc.close();
	}

	static int[] solve(String s, String[] t) {
		int[][] lengthAndCounts = new int[s.length() + 1][SIZE];
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < SIZE; j++) {
				lengthAndCounts[i][j] = lengthAndCounts[i - 1][j];
			}

			lengthAndCounts[i][s.charAt(i - 1) - 'a']++;
		}

		return Arrays.stream(t).mapToInt(name -> computeMinPrefixLength(lengthAndCounts, name)).toArray();
	}

	static int computeMinPrefixLength(int[][] lengthAndCounts, String name) {
		int[] nameCounts = new int[SIZE];
		for (int i = 0; i < name.length(); i++) {
			nameCounts[name.charAt(i) - 'a']++;
		}

		int lower = 0;
		int upper = lengthAndCounts.length - 1;
		int result = -1;
		while (lower <= upper) {
			int middle = (lower + upper) / 2;

			if (IntStream.range(0, SIZE).allMatch(i -> lengthAndCounts[middle][i] >= nameCounts[i])) {
				result = middle;

				upper = middle - 1;
			} else {
				lower = middle + 1;
			}
		}

		return result;
	}
}
