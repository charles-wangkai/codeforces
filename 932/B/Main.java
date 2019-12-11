import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static final int LIMIT = 1_000_000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Q = sc.nextInt();
		Query[] queries = new Query[Q];
		for (int i = 0; i < queries.length; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int k = sc.nextInt();

			queries[i] = new Query(l, r, k);
		}
		System.out.println(solve(queries));

		sc.close();
	}

	static String solve(Query[] queries) {
		int[] g = new int[LIMIT + 1];
		for (int i = 0; i < g.length; i++) {
			if (i < 10) {
				g[i] = i;
			} else {
				g[i] = g[String.valueOf(i).chars().map(ch -> ch - '0').filter(x -> x != 0).reduce((x, y) -> x * y)
						.getAsInt()];
			}
		}

		int[][] prefixSums = new int[10][LIMIT + 1];
		for (int i = 0; i < prefixSums.length; i++) {
			int prefixSum = 0;
			for (int j = 0; j < prefixSums[i].length; j++) {
				if (g[j] == i) {
					prefixSum++;
				}

				prefixSums[i][j] = prefixSum;
			}
		}

		return Arrays.stream(queries)
				.map(query -> String.valueOf(prefixSums[query.k][query.r] - prefixSums[query.k][query.l - 1]))
				.collect(Collectors.joining("\n"));
	}
}

class Query {
	int l;
	int r;
	int k;

	Query(int l, int r, int k) {
		this.l = l;
		this.r = r;
		this.k = k;
	}
}