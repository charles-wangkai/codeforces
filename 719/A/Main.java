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

	static String solve(int[] a) {
		if (a.length == 1) {
			if (a[0] == 0) {
				return "UP";
			} else if (a[0] == 15) {
				return "DOWN";
			} else {
				return "-1";
			}
		} else if ((a[a.length - 2] < a[a.length - 1] && a[a.length - 1] <= 14)
				|| (a[a.length - 2] == 1 && a[a.length - 1] == 0)) {
			return "UP";
		} else {
			return "DOWN";
		}
	}
}
