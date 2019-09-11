import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] sequences = new String[n];
		for (int i = 0; i < sequences.length; i++) {
			sequences[i] = sc.next();
		}
		System.out.println(solve(sequences));

		sc.close();
	}

	static int solve(String[] sequences) {
		int countForZeroDepth = 0;
		Map<Integer, Integer> positiveDepthToCount = new HashMap<>();
		Map<Integer, Integer> negativeDepthToCount = new HashMap<>();

		for (String sequence : sequences) {
			int depth = 0;
			int minDepth = 0;
			for (char ch : sequence.toCharArray()) {
				if (ch == '(') {
					depth++;
				} else {
					depth--;
				}

				minDepth = Math.min(minDepth, depth);
			}

			if (depth == 0) {
				if (minDepth == 0) {
					countForZeroDepth++;
				}
			} else if (depth > 0) {
				if (minDepth == 0) {
					positiveDepthToCount.put(depth, positiveDepthToCount.getOrDefault(depth, 0) + 1);
				}
			} else {
				if (minDepth == depth) {
					negativeDepthToCount.put(depth, negativeDepthToCount.getOrDefault(depth, 0) + 1);
				}
			}
		}

		return countForZeroDepth / 2 + positiveDepthToCount.keySet().stream()
				.map(depth -> Math.min(positiveDepthToCount.get(depth), negativeDepthToCount.getOrDefault(-depth, 0)))
				.mapToInt(x -> x).sum();
	}
}
