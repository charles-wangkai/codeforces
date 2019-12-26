import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int maxProfitSum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] profits = new int[N];
		for (int i = 0; i < profits.length; ++i) {
			profits[i] = sc.nextInt();
		}
		int[] a = new int[N - 1];
		int[] b = new int[N - 1];
		for (int i = 0; i < N - 1; ++i) {
			a[i] = sc.nextInt() - 1;
			b[i] = sc.nextInt() - 1;
		}
		System.out.println(solve(profits, a, b));

		sc.close();
	}

	static int solve(int[] profits, int[] a, int[] b) {
		int max = Arrays.stream(profits).max().getAsInt();
		if (max <= 0) {
			return max;
		}

		int N = profits.length;

		@SuppressWarnings("unchecked")
		List<Integer>[] adjLists = new List[N];
		for (int i = 0; i < adjLists.length; ++i) {
			adjLists[i] = new ArrayList<>();
		}

		for (int i = 0; i < a.length; ++i) {
			adjLists[a[i]].add(b[i]);
			adjLists[b[i]].add(a[i]);
		}

		maxProfitSum = Integer.MIN_VALUE;
		search(profits, adjLists, Arrays.stream(profits).sum(), new boolean[N], 0);

		return maxProfitSum;
	}

	static int search(int[] profits, List<Integer>[] adjLists, int profitTotal, boolean[] visited, int node) {
		if (visited[node]) {
			return 0;
		}

		visited[node] = true;
		int sum = profits[node];
		for (int adj : adjLists[node]) {
			sum += search(profits, adjLists, profitTotal, visited, adj);
		}
		sum = Math.max(0, sum);

		maxProfitSum = Math.max(maxProfitSum, sum);

		return sum;
	}
}
