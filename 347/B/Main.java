import java.util.Scanner;
import java.util.stream.IntStream;

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
		modify(a);

		return (int) IntStream.range(0, a.length).filter(i -> a[i] == i).count();
	}

	static void modify(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != i && a[a[i]] == i) {
				swap(a, i, a[i]);

				return;
			}
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] != i) {
				swap(a, i, a[i]);

				return;
			}
		}
	}

	static void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}
