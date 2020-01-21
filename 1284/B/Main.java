import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] s = new int[n][];
		for (int i = 0; i < s.length; ++i) {
			int l = sc.nextInt();
			s[i] = new int[l];
			for (int j = 0; j < s[i].length; ++j) {
				s[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve(s));

		sc.close();
	}

	static long solve(int[][] s) {
		Sequence[] sequences = Arrays.stream(s).map(Sequence::new).toArray(Sequence[]::new);

		Sequence[] nonAscentSequences = Arrays.stream(sequences).filter(sequence -> !sequence.ascent)
				.toArray(Sequence[]::new);
		int ascentCount = sequences.length - nonAscentSequences.length;

		long result = 2L * ascentCount * nonAscentSequences.length + (long) ascentCount * ascentCount;

		Sequence[] leftNonAscentSequences = Arrays.stream(nonAscentSequences)
				.sorted((s1, s2) -> Integer.compare(s1.min, s2.min)).toArray(Sequence[]::new);
		Sequence[] rightNonAscentSequences = Arrays.stream(nonAscentSequences)
				.sorted((s1, s2) -> Integer.compare(s1.max, s2.max)).toArray(Sequence[]::new);

		int rightIndex = 0;
		for (int i = 0; i < leftNonAscentSequences.length; ++i) {
			while (rightIndex != rightNonAscentSequences.length
					&& leftNonAscentSequences[i].min >= rightNonAscentSequences[rightIndex].max) {
				++rightIndex;
			}

			result += rightNonAscentSequences.length - rightIndex;
		}

		return result;
	}
}

class Sequence {
	boolean ascent;
	int min;
	int max;

	Sequence(int[] a) {
		ascent = IntStream.range(0, a.length - 1).anyMatch(i -> a[i] < a[i + 1]);
		min = Arrays.stream(a).min().getAsInt();
		max = Arrays.stream(a).max().getAsInt();
	}
}