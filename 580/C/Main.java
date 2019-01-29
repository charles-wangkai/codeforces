import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		@SuppressWarnings("unchecked")
		List<Integer>[] adjacentLists = new List[n];
		for (int i = 0; i < adjacentLists.length; i++) {
			adjacentLists[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			adjacentLists[x - 1].add(y - 1);
			adjacentLists[y - 1].add(x - 1);
		}
		System.out.println(solve(a, adjacentLists, m));

		sc.close();
	}

	static int solve(int[] a, List<Integer>[] adjacentLists, int m) {
		int[] consecutiveCatNum = new int[a.length];
		Arrays.fill(consecutiveCatNum, -1);
		consecutiveCatNum[0] = a[0];

		return search(a, adjacentLists, m, consecutiveCatNum, 0);
	}

	static int search(int[] a, List<Integer>[] adjacentLists, int m, int[] consecutiveCatNum, int nodeIndex) {
		if (consecutiveCatNum[nodeIndex] > m) {
			return 0;
		}

		List<Integer> children = adjacentLists[nodeIndex].stream().filter(adjacent -> consecutiveCatNum[adjacent] == -1)
				.collect(Collectors.toList());
		if (children.isEmpty()) {
			return 1;
		}

		int result = 0;
		for (int child : children) {
			consecutiveCatNum[child] = (a[child] == 1) ? (consecutiveCatNum[nodeIndex] + 1) : 0;

			result += search(a, adjacentLists, m, consecutiveCatNum, child);
		}
		return result;
	}
}
