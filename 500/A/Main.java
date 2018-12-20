import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();
		int[] a = new int[n];
		for (int i = 1; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, t) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] a, int t) {
		int index = 1;
		while (true) {
			index += a[index];

			if (index == t) {
				return true;
			} else if (index > t) {
				return false;
			}
		}
	}
}
