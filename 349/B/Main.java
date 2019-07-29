import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int v = sc.nextInt();
		int[] a = new int[10];
		for (int i = 1; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(v, a));

		sc.close();
	}

	static String solve(int v, int[] a) {
		int minA = Arrays.stream(a, 1, a.length).min().getAsInt();

		int length = v / minA;
		if (length == 0) {
			return "-1";
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < length; i++) {
			for (int digit = 9;; digit--) {
				if (a[digit] <= v && (v - a[digit]) / minA == length - i - 1) {
					result.append(digit);
					v -= a[digit];

					break;
				}
			}
		}
		return result.toString();
	}
}
