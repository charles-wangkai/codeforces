import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int LIMIT = 5_000_000;

	static int[] scorePrefixSums = buildScorePrefixSums();

	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			output.append(solve(a, b)).append("\n");
		}
		System.out.print(output);
	}

	static int solve(int a, int b) {
		return scorePrefixSums[a] - scorePrefixSums[b];
	}

	static int[] buildScorePrefixSums() {
		int[] scores = new int[LIMIT + 1];

		boolean[] primes = new boolean[scores.length];
		Arrays.fill(primes, true);

		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				for (int j = i; j < primes.length; j += i) {
					primes[j] = false;

					scores[j] = scores[j / i] + 1;
				}
			}
		}

		int[] scorePrefixSums = new int[scores.length];
		int scorePrefixSum = 0;
		for (int i = 0; i < scorePrefixSums.length; i++) {
			scorePrefixSum += scores[i];
			scorePrefixSums[i] = scorePrefixSum;
		}

		return scorePrefixSums;
	}
}
