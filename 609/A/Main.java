import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, m));

		sc.close();
	}

	static int solve(int[] a, int m) {
		int[] sorted = Arrays.stream(a).boxed().sorted(Collections.reverseOrder()).mapToInt(x -> x).toArray();

		int sum = 0;
		for (int i = 0;; i++) {
			sum += sorted[i];

			if (sum >= m) {
				return i + 1;
			}
		}
	}
}
