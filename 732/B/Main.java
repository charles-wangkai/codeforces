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
		System.out.print(solve(a, k));

		sc.close();
	}

	static String solve(int[] a, int k) {
		int[] b = new int[a.length];
		b[0] = a[0];
		for (int i = 1; i < b.length; i++) {
			b[i] = Math.max(a[i], k - b[i - 1]);
		}

		return new StringBuilder().append(Arrays.stream(b).sum() - Arrays.stream(a).sum()).append("\n")
				.append(String.join(" ", Arrays.stream(b).mapToObj(String::valueOf).toArray(String[]::new)))
				.append("\n").toString();
	}
}
