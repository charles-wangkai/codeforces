import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < m; j++) {
				a[i][j] = line.charAt(j) - '0';
			}
		}
		System.out.println(solve(a) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[][] a) {
		int n = a.length;
		int m = a[0].length;

		@SuppressWarnings("unchecked")
		List<Integer>[] switchIndexLists = new List[m];
		for (int i = 0; i < switchIndexLists.length; i++) {
			switchIndexLists[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 1) {
					switchIndexLists[j].add(i);
				}
			}
		}

		return Arrays.stream(switchIndexLists).filter(switchIndexList -> switchIndexList.size() == 1)
				.mapToInt(switchIndexList -> switchIndexList.get(0)).distinct().count() < a.length;
	}
}
