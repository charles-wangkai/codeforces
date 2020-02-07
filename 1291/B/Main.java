import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; ++i) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a) ? "Yes" : "No");
		}

		sc.close();
	}

	static boolean solve(int[] a) {
		int index = 0;
		while (index < a.length && a[index] >= index) {
			++index;
		}

		if (index == a.length) {
			return true;
		}

		if (a.length - index - 1 >= a[index - 1]) {
			return false;
		}

		while (index < a.length && a[index] >= a.length - index - 1) {
			++index;
		}

		return index == a.length;
	}
}
