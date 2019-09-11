import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		System.out.print(solve(a));
	}

	static String solve(int[] a) {
		SortedMap<Integer, List<Integer>> valueToIndices = new TreeMap<>();
		for (int i = 0; i < a.length; i++) {
			if (!valueToIndices.containsKey(a[i])) {
				valueToIndices.put(a[i], new ArrayList<>());
			}

			valueToIndices.get(a[i]).add(i);
		}

		List<String> pairs = new ArrayList<>();
		for (int value : valueToIndices.keySet()) {
			List<Integer> indices = valueToIndices.get(value);

			if (isArithmeticProgression(indices)) {
				pairs.add(String.format("%d %d", value, computeCommonDiff(indices)));
			}
		}

		return String.format("%d\n%s", pairs.size(), String.join("\n", pairs));
	}

	static boolean isArithmeticProgression(List<Integer> indices) {
		if (indices.size() == 1) {
			return true;
		}

		for (int i = 1; i < indices.size() - 1; i++) {
			if (indices.get(i + 1) - indices.get(i) != indices.get(1) - indices.get(0)) {
				return false;
			}
		}

		return true;
	}

	static int computeCommonDiff(List<Integer> indices) {
		return (indices.size() == 1) ? 0 : (indices.get(1) - indices.get(0));
	}
}
