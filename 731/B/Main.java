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
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0) {
				if (i + 1 == a.length || a[i + 1] == 0) {
					return false;
				}

				a[i + 1]--;
			}
		}

		return true;
	}
}
