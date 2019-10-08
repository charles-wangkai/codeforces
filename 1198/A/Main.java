import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int I = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve(a, I));
	}

	static int solve(int[] a, int I) {
		SortedMap<Integer, Integer> valueToCount = new TreeMap<>();
		for (int value : a) {
			valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
		}

		List<Integer> counts = valueToCount.values().stream().collect(Collectors.toList());

		int bitNum = I * 8 / a.length;
		int windowSize = 1;
		for (int i = 0; i < bitNum; i++) {
			windowSize *= 2;

			if (windowSize > counts.size()) {
				return 0;
			}
		}

		int sum = IntStream.range(0, windowSize).map(counts::get).sum();
		int maxSum = sum;
		for (int i = windowSize; i < counts.size(); i++) {
			sum += counts.get(i) - counts.get(i - windowSize);
			maxSum = Math.max(maxSum, sum);
		}

		return a.length - maxSum;
	}
}
