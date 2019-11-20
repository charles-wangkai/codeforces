import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int q = sc.nextInt();
		int[][] grid = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		int[] roundRs = new int[q];
		int[] roundCs = new int[q];
		for (int i = 0; i < q; i++) {
			roundRs[i] = sc.nextInt() - 1;
			roundCs[i] = sc.nextInt() - 1;
		}
		System.out.println(solve(grid, roundRs, roundCs));

		sc.close();
	}

	static String solve(int[][] grid, int[] roundRs, int[] roundCs) {
		SortedMap<Integer, Integer> maxLengthToCount = new TreeMap<>();
		for (int[] row : grid) {
			updateMap(maxLengthToCount, computeMaxLength(row), 1);
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < roundRs.length; i++) {
			updateMap(maxLengthToCount, computeMaxLength(grid[roundRs[i]]), -1);
			grid[roundRs[i]][roundCs[i]] = 1 - grid[roundRs[i]][roundCs[i]];
			updateMap(maxLengthToCount, computeMaxLength(grid[roundRs[i]]), 1);

			result.add(maxLengthToCount.lastKey());
		}

		return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
	}

	static int computeMaxLength(int[] row) {
		int result = 0;
		int length = 0;
		for (int x : row) {
			if (x == 1) {
				length++;
				result = Math.max(result, length);
			} else {
				length = 0;
			}
		}

		return result;
	}

	static void updateMap(SortedMap<Integer, Integer> maxLengthToCount, int key, int valueDelta) {
		maxLengthToCount.put(key, maxLengthToCount.getOrDefault(key, 0) + valueDelta);
		maxLengthToCount.remove(key, 0);
	}
}
