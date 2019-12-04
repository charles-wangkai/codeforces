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

	static int solve(int[] a) {
		int enterTime = -1;
		int lower = 0;
		int upper = Arrays.stream(a).max().getAsInt() + a.length;
		while (lower <= upper) {
			int middle = (lower + upper) / 2;

			if (check(a, middle)) {
				enterTime = middle;
				upper = middle - 1;
			} else {
				lower = middle + 1;
			}
		}

		return enterTime % a.length + 1;
	}

	static boolean check(int[] a, int time) {
		for (int i = 0; i < a.length && i <= time; i++) {
			int lastVisitTime = (time - i) / a.length * a.length + i;

			if (lastVisitTime >= a[i]) {
				return true;
			}
		}

		return false;
	}
}
