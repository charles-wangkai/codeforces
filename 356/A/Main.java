import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] l = new int[m];
		int[] r = new int[m];
		int[] x = new int[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			l[i] = Integer.parseInt(st.nextToken());
			r[i] = Integer.parseInt(st.nextToken());
			x[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve(n, l, r, x));
	}

	static String solve(int n, int[] l, int[] r, int[] x) {
		List<Integer>[] beginLists = initLists(n);
		List<Integer>[] endLists = initLists(n);

		for (int i = 0; i < l.length; i++) {
			if (x[i] != l[i]) {
				beginLists[l[i]].add(i);
				endLists[x[i] - 1].add(i);
			}
			if (x[i] != r[i]) {
				beginLists[x[i] + 1].add(i);
				endLists[r[i]].add(i);
			}
		}

		int[] result = new int[n + 1];
		SortedSet<Integer> indexSet = new TreeSet<>();
		for (int i = 1; i < result.length; i++) {
			for (int begin : beginLists[i]) {
				indexSet.add(begin);
			}

			if (!indexSet.isEmpty()) {
				result[i] = x[indexSet.first()];
			}

			for (int end : endLists[i]) {
				indexSet.remove(end);
			}
		}

		return IntStream.range(1, result.length).mapToObj(i -> String.valueOf(result[i]))
				.collect(Collectors.joining(" "));
	}

	static List<Integer>[] initLists(int n) {
		@SuppressWarnings("unchecked")
		List<Integer>[] result = new List[n + 1];
		for (int i = 1; i < result.length; i++) {
			result[i] = new ArrayList<>();
		}

		return result;
	}
}
