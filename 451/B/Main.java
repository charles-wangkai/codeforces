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
		System.out.print(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		int[] sorted = Arrays.stream(a).sorted().toArray();

		int minDiffIndex = 0;
		while (minDiffIndex < a.length && a[minDiffIndex] == sorted[minDiffIndex]) {
			minDiffIndex++;
		}

		if (minDiffIndex == a.length) {
			return "yes\n1 1";
		}

		int maxDiffIndex = a.length - 1;
		while (a[maxDiffIndex] == sorted[maxDiffIndex]) {
			maxDiffIndex--;
		}

		reverse(a, minDiffIndex, maxDiffIndex);

		if (Arrays.equals(a, sorted)) {
			return String.format("yes\n%d %d", minDiffIndex + 1, maxDiffIndex + 1);
		} else {
			return "no";
		}
	}

	static void reverse(int[] a, int beginIndex, int endIndex) {
		for (int i = beginIndex, j = endIndex; i < j; i++, j--) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
}
