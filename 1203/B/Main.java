import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			int[] a = new int[n * 4];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int[] a) {
		a = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

		int area = a[0] * a[a.length - 1];
		for (int i = 0, j = a.length - 1; i < j; i += 2, j -= 2) {
			if (!(a[i] == a[i + 1] && a[j] == a[j - 1] && a[i] * a[j] == area)) {
				return false;
			}
		}

		return true;
	}
}
