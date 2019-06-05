import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(int[] a) {
		return isOdd(a.length) && isOdd(a[0]) && isOdd(a[a.length - 1]);
	}

	static boolean isOdd(int x) {
		return x % 2 != 0;
	}
}
