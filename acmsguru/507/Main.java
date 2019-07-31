import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] parents = new int[n + 1];
		for (int i = 2; i < parents.length; i++) {
			st = new StringTokenizer(br.readLine());

			parents[i] = Integer.parseInt(st.nextToken());
		}
		Map<Integer, Integer> idToValue = new HashMap<>();
		for (int id = n - m + 1; id <= n; id++) {
			st = new StringTokenizer(br.readLine());

			int value = Integer.parseInt(st.nextToken());
			idToValue.put(id, value);
		}
		System.out.println(solve(parents, idToValue));
	}

	@SuppressWarnings("unchecked")
	static String solve(int[] parents, Map<Integer, Integer> idToValue) {
		int n = parents.length - 1;
		int m = idToValue.size();

		int[] minAbsDiffs = new int[n + 1];
		Arrays.fill(minAbsDiffs, Integer.MAX_VALUE);

		NavigableSet<Integer>[] valueSets = new NavigableSet[n + 1];
		for (int id : idToValue.keySet()) {
			NavigableSet<Integer> valueSet = new TreeSet<>();
			valueSet.add(idToValue.get(id));

			valueSets[id] = valueSet;
		}

		List<Integer>[] childrens = new List[n - m + 1];
		for (int i = 1; i < childrens.length; i++) {
			childrens[i] = new ArrayList<>();
		}
		for (int i = 2; i < parents.length; i++) {
			childrens[parents[i]].add(i);
		}

		search(childrens, minAbsDiffs, valueSets, 1);

		StringBuilder result = new StringBuilder();
		for (int i = 1; i <= n - m; i++) {
			if (i != 1) {
				result.append(" ");
			}

			result.append(minAbsDiffs[i]);
		}
		return result.toString();
	}

	static void search(List<Integer>[] childrens, int[] minAbsDiffs, NavigableSet<Integer>[] valueSets, int id) {
		for (int child : childrens[id]) {
			if (child < childrens.length) {
				search(childrens, minAbsDiffs, valueSets, child);
			}
		}

		int childWithMaxSize = childrens[id].get(0);
		for (int child : childrens[id]) {
			if (valueSets[child].size() > valueSets[childWithMaxSize].size()) {
				childWithMaxSize = child;
			}
		}

		NavigableSet<Integer> merged = valueSets[childWithMaxSize];
		for (int child : childrens[id]) {
			minAbsDiffs[id] = Math.min(minAbsDiffs[id], minAbsDiffs[child]);

			if (child != childWithMaxSize) {
				for (int value : valueSets[child]) {
					Integer floor = merged.floor(value);
					if (floor != null) {
						minAbsDiffs[id] = Math.min(minAbsDiffs[id], value - floor);
					}

					Integer ceiling = merged.ceiling(value);
					if (ceiling != null) {
						minAbsDiffs[id] = Math.min(minAbsDiffs[id], ceiling - value);
					}

					merged.add(value);
				}
			}
		}
		valueSets[id] = merged;
	}
}
