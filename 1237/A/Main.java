import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
		int delta = 1;
		int[] b = new int[a.length];
		for (int i = 0; i < b.length; i++) {
			if (a[i] % 2 == 0) {
				b[i] = a[i] / 2;
			} else {
				b[i] = (a[i] + delta) / 2;

				delta *= -1;
			}
		}

		return Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
	}
}
