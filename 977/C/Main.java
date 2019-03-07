import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, k));

		sc.close();
	}

	static int solve(int[] a, int k) {
		a = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

		if (k == 0) {
			if (a[0] == 1) {
				return -1;
			} else {
				return a[0] - 1;
			}
		} else if (k == a.length || a[k - 1] != a[k]) {
			return a[k - 1];
		} else {
			return -1;
		}
	}
}
