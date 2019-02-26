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
		int indexFirst = find(a, 1);
		int indexLast = find(a, a.length);

		return Math.max(Math.max(indexFirst, a.length - 1 - indexFirst), Math.max(indexLast, a.length - 1 - indexLast));
	}

	static int find(int[] a, int target) {
		for (int i = 0;; i++) {
			if (a[i] == target) {
				return i;
			}
		}
	}
}
