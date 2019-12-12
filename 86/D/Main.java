import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	static final int LIMIT = 1_000_000;

	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Query[] queries = new Query[t];
		for (int i = 0; i < queries.length; i++) {
			st = new StringTokenizer(br.readLine());

			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken()) - 1;

			queries[i] = new Query(i, l, r);
		}
		System.out.println(solve(a, queries));
	}

	static String solve(int[] a, Query[] queries) {
		int[] counts = new int[LIMIT + 1];
		long power = 0;
		int beginIndex = 0;
		int endIndex = -1;
		long[] result = new long[queries.length];

		int blockSize = (int) Math.round(Math.sqrt(queries.length));
		Arrays.sort(queries,
				(q1, q2) -> (q1.l / blockSize != q2.l / blockSize) ? Integer.compare(q1.l / blockSize, q2.l / blockSize)
						: Integer.compare(q1.r, q2.r));

		for (Query query : queries) {
			while (beginIndex < query.l) {
				counts[a[beginIndex]]--;
				power -= (2L * counts[a[beginIndex]] + 1) * a[beginIndex];
				beginIndex++;
			}
			while (beginIndex > query.l) {
				beginIndex--;
				power += (2L * counts[a[beginIndex]] + 1) * a[beginIndex];
				counts[a[beginIndex]]++;
			}

			while (endIndex < query.r) {
				endIndex++;
				power += (2L * counts[a[endIndex]] + 1) * a[endIndex];
				counts[a[endIndex]]++;
			}
			while (endIndex > query.r) {
				counts[a[endIndex]]--;
				power -= (2L * counts[a[endIndex]] + 1) * a[endIndex];
				endIndex--;
			}

			result[query.index] = power;
		}

		return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
	}
}

class Query {
	int index;
	int l;
	int r;

	Query(int index, int l, int r) {
		this.index = index;
		this.l = l;
		this.r = r;
	}
}