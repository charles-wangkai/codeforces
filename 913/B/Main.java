import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] parents = new int[n];
		for (int i = 1; i < parents.length; i++) {
			parents[i] = sc.nextInt() - 1;
		}
		System.out.println(solve(parents) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(int[] parents) {
		@SuppressWarnings("unchecked")
		List<Integer>[] childrens = new List[parents.length];
		for (int i = 0; i < childrens.length; i++) {
			childrens[i] = new ArrayList<>();
		}

		for (int i = 1; i < parents.length; i++) {
			childrens[parents[i]].add(i);
		}

		return isSpruce(childrens, 0);
	}

	static boolean isSpruce(List<Integer>[] childrens, int node) {
		if (isLeaf(childrens, node)) {
			return true;
		}

		int leafChildCount = 0;
		for (int child : childrens[node]) {
			if (isLeaf(childrens, child)) {
				leafChildCount++;
			} else {
				if (!isSpruce(childrens, child)) {
					return false;
				}
			}
		}
		return leafChildCount >= 3;
	}

	static boolean isLeaf(List<Integer>[] childrens, int node) {
		return childrens[node].isEmpty();
	}
}
