import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] a = new int[1 << n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int[] p = new int[m];
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		System.out.print(solve(n, a, p, b));
	}

	static String solve(int n, int[] a, int[] p, int[] b) {
		Map<Range, Integer> rangeToResult = new HashMap<>();
		buildRangeToResult(rangeToResult, a, 0, a.length - 1, n % 2 != 0);

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < p.length; i++) {
			result.append(compute(rangeToResult, a, p[i] - 1, b[i], 0, a.length - 1, n % 2 != 0)).append("\n");
		}
		return result.toString();
	}

	static int buildRangeToResult(Map<Range, Integer> rangeToResult, int[] a, int beginIndex, int endIndex,
			boolean orOrXor) {
		int result;
		if (beginIndex == endIndex) {
			result = a[beginIndex];
		} else {
			int middleIndex = (beginIndex + endIndex) / 2;

			int leftSubResult = buildRangeToResult(rangeToResult, a, beginIndex, middleIndex, !orOrXor);
			int rightSubResult = buildRangeToResult(rangeToResult, a, middleIndex + 1, endIndex, !orOrXor);

			if (orOrXor) {
				result = leftSubResult | rightSubResult;
			} else {
				result = leftSubResult ^ rightSubResult;
			}
		}

		rangeToResult.put(new Range(beginIndex, endIndex), result);
		return result;
	}

	static int compute(Map<Range, Integer> rangeToResult, int[] a, int changedIndex, int changedValue, int beginIndex,
			int endIndex, boolean orOrXor) {
		Range range = new Range(beginIndex, endIndex);
		if (changedIndex >= beginIndex && changedIndex <= endIndex) {
			int newResult;
			if (beginIndex == endIndex) {
				newResult = changedValue;
			} else {
				int middleIndex = (beginIndex + endIndex) / 2;

				int leftSubResult = compute(rangeToResult, a, changedIndex, changedValue, beginIndex, middleIndex,
						!orOrXor);
				int rightSubResult = compute(rangeToResult, a, changedIndex, changedValue, middleIndex + 1, endIndex,
						!orOrXor);

				if (orOrXor) {
					newResult = leftSubResult | rightSubResult;
				} else {
					newResult = leftSubResult ^ rightSubResult;
				}
			}

			rangeToResult.put(range, newResult);
			return newResult;
		} else {
			return rangeToResult.get(range);
		}
	}
}

class Range {
	int beginIndex;
	int endIndex;

	Range(int beginIndex, int endIndex) {
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
	}

	@Override
	public int hashCode() {
		return Objects.hash(beginIndex, endIndex);
	}

	@Override
	public boolean equals(Object obj) {
		Range other = (Range) obj;
		return beginIndex == other.beginIndex && endIndex == other.endIndex;
	}
}