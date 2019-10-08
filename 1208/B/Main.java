import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		int maxSize = 0;
		Set<Integer> leftSet = new HashSet<>();
		for (int leftLength = 0; leftLength <= a.length; leftLength++) {
			Set<Integer> rightSet = new HashSet<>();
			for (int j = a.length - 1; j >= leftLength; j--) {
				if (leftSet.contains(a[j]) || rightSet.contains(a[j])) {
					break;
				}

				rightSet.add(a[j]);
			}

			maxSize = Math.max(maxSize, leftSet.size() + rightSet.size());

			if (leftLength != a.length) {
				if (leftSet.contains(a[leftLength])) {
					break;
				}

				leftSet.add(a[leftLength]);
			}
		}

		return a.length - maxSize;
	}
}
