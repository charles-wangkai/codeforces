import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] v = new int[n];
		for (int i = 0; i < v.length; i++) {
			v[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		Question[] questions = new Question[m];
		for (int i = 0; i < questions.length; i++) {
			int type = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();

			questions[i] = new Question(type, l, r);
		}
		System.out.print(solve(v, questions));

		sc.close();
	}

	static String solve(int[] v, Question[] questions) {
		long[] originalPrefixSums = buildPrefixSums(v);
		long[] sortedPrefixSums = buildPrefixSums(Arrays.stream(v).boxed().sorted().mapToInt(x -> x).toArray());

		return String.join("\n",
				Arrays.stream(questions)
						.map(question -> String.valueOf(computeRangeSum(
								(question.type == 1) ? originalPrefixSums : sortedPrefixSums, question.l, question.r)))
						.toArray(String[]::new));
	}

	static long[] buildPrefixSums(int[] a) {
		long[] result = new long[a.length + 1];
		for (int i = 1; i < result.length; i++) {
			result[i] = result[i - 1] + a[i - 1];
		}
		return result;
	}

	static long computeRangeSum(long[] prefixSums, int l, int r) {
		return prefixSums[r] - prefixSums[l - 1];
	}
}

class Question {
	int type;
	int l;
	int r;

	Question(int type, int l, int r) {
		this.type = type;
		this.l = l;
		this.r = r;
	}
}