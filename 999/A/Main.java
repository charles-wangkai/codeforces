import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, k));

		sc.close();
	}

	static int solve(int[] a, int k) {
		int leftIndex = 0;
		while (leftIndex < a.length && a[leftIndex] <= k) {
			leftIndex++;
		}

		if (leftIndex == a.length) {
			return a.length;
		}

		int rightIndex = a.length - 1;
		while (rightIndex >= 0 && a[rightIndex] <= k) {
			rightIndex--;
		}

		return leftIndex + (a.length - 1 - rightIndex);
	}
}
