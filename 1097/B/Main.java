import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] a) {
		return search(a, 0, 0);
	}

	static boolean search(int[] a, int degree, int index) {
		if (index == a.length) {
			return degree % 360 == 0;
		}

		return search(a, degree - a[index], index + 1) || search(a, degree + a[index], index + 1);
	}
}
