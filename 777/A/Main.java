import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		System.out.println(solve(n, x));

		sc.close();
	}

	static int solve(int n, int x) {
		int[] sources = IntStream.range(0, 3).toArray();
		for (int i = 0; i < n % 6; i++) {
			if (i % 2 == 0) {
				swap(sources, 0, 1);
			} else {
				swap(sources, 1, 2);
			}
		}
		return sources[x];
	}

	static void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}
