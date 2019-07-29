import java.util.Arrays;
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
		if (a.length == 1 || (a.length == 2 && a[0] == a[1])) {
			return "-1";
		}

		int sum = Arrays.stream(a).sum();
		for (int i = 0;; i++) {
			if (a[i] * 2 != sum) {
				return String.format("1\n%d", i + 1);
			}
		}
	}
}
