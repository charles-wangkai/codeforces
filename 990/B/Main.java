import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int K = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, K));

		sc.close();
	}

	static int solve(int[] a, int K) {
		a = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

		int result = 0;
		boolean prevSwallowed = false;
		for (int i = a.length - 1; i >= 0; i--) {
			if (i != a.length - 1
					&& ((a[i] == a[i + 1] && prevSwallowed) || (a[i] != a[i + 1] && a[i + 1] - a[i] <= K))) {
				prevSwallowed = true;
			} else {
				result++;

				prevSwallowed = false;
			}
		}

		return result;
	}
}
