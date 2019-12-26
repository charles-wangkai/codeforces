import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < p.length; ++i) {
			p[i] = sc.nextInt();
		}
		int[] l = new int[m];
		int[] r = new int[m];
		int[] x = new int[m];
		for (int i = 0; i < m; ++i) {
			l[i] = sc.nextInt() - 1;
			r[i] = sc.nextInt() - 1;
			x[i] = sc.nextInt() - 1;
		}
		System.out.println(solve(p, l, r, x));

		sc.close();
	}

	static String solve(int[] p, int[] l, int[] r, int[] x) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < l.length; ++i) {
			result.add((countLessThan(p, l[i], r[i], p[x[i]]) == x[i] - l[i]) ? "Yes" : "No");
		}

		return String.join("\n", result);
	}

	static int countLessThan(int[] p, int leftIndex, int rightIndex, int target) {
		int result = 0;
		for (int i = leftIndex; i <= rightIndex; ++i) {
			if (p[i] < target) {
				result++;
			}
		}

		return result;
	}
}
