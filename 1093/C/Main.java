import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long[] b = new long[n / 2];
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextLong();
		}
		System.out.println(solve(b));

		sc.close();
	}

	static String solve(long[] b) {
		long[] a = new long[b.length * 2];
		a[a.length - 1] = b[0];
		for (int i = 1; i < b.length; i++) {
			a[i] = Math.max(a[i - 1], b[i] - a[a.length - i]);
			a[a.length - i - 1] = b[i] - a[i];
		}

		return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}
}
