import java.util.Arrays;
import java.util.Scanner;

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
		int[] sortedDistincts = Arrays.stream(a).distinct().sorted().toArray();
		if (sortedDistincts.length == 1) {
			return 0;
		} else if (sortedDistincts.length == 2) {
			int diff = sortedDistincts[1] - sortedDistincts[0];

			return (diff % 2 == 0) ? (diff / 2) : diff;
		} else if (sortedDistincts.length == 3) {
			int diff0 = sortedDistincts[1] - sortedDistincts[0];
			int diff1 = sortedDistincts[2] - sortedDistincts[1];

			if (diff0 == diff1) {
				return diff0;
			}
		}
		return -1;
	}
}
