import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a));
		}

		sc.close();
	}

	static String solve(int[] a) {
		int[] indices = new int[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			indices[a[i]] = i;
		}

		int minIndex = 0;
		for (int value = 1; value <= a.length; value++) {
			int nextMinIndex = Math.max(minIndex, indices[value]);

			for (int j = indices[value] - 1; j >= minIndex; j--) {
				if (a[j] > a[j + 1]) {
					swap(a, indices, j, j + 1);
				}
			}

			minIndex = nextMinIndex;
		}

		return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}

	static void swap(int[] a, int[] indices, int index1, int index2) {
		swapInArray(indices, a[index1], a[index2]);
		swapInArray(a, index1, index2);
	}

	static void swapInArray(int[] p, int i1, int i2) {
		int temp = p[i1];
		p[i1] = p[i2];
		p[i2] = temp;
	}
}
