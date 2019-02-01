import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] votes = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				votes[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve(votes));

		sc.close();
	}

	static int solve(int[][] votes) {
		return stage2(Arrays.stream(votes).mapToInt(Main::stage1).toArray());
	}

	static int stage1(int[] cityVotes) {
		int maxVote = Arrays.stream(cityVotes).max().getAsInt();

		for (int i = 0;; i++) {
			if (cityVotes[i] == maxVote) {
				return i + 1;
			}
		}
	}

	static int stage2(int[] countryVotes) {
		Map<Integer, Integer> voteToCount = new HashMap<>();
		for (int countryVote : countryVotes) {
			voteToCount.put(countryVote, voteToCount.getOrDefault(countryVote, 0) + 1);
		}

		int maxCount = voteToCount.values().stream().mapToInt(x -> x).max().getAsInt();

		return voteToCount.keySet().stream().filter(vote -> voteToCount.get(vote) == maxCount).mapToInt(x -> x).min()
				.getAsInt();
	}
}
