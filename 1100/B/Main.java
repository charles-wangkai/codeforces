import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(Arrays.stream(solve(n, a)).mapToObj(String::valueOf).collect(Collectors.joining()));

		sc.close();
	}

	static int[] solve(int n, int[] a) {
		int[] counts = new int[n + 1];
		SortedMap<Integer, Integer> countToFreq = new TreeMap<>();
		countToFreq.put(0, n);
		int minCount = 0;

		int[] result = new int[a.length];
		for (int i = 0; i < result.length; i++) {
			countToFreq.put(counts[a[i]], countToFreq.get(counts[a[i]]) - 1);
			countToFreq.remove(counts[a[i]], 0);

			counts[a[i]]++;
			countToFreq.put(counts[a[i]], countToFreq.getOrDefault(counts[a[i]], 0) + 1);

			int nextMinCount = countToFreq.firstKey();
			if (nextMinCount != minCount) {
				minCount = nextMinCount;

				result[i] = 1;
			}
		}
		return result;
	}
}
