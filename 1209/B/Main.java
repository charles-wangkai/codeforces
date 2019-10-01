import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int LIMIT = 125;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String s = sc.next();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.println(solve(s, a, b));

		sc.close();
	}

	static int solve(String s, int[] a, int[] b) {
		int n = s.length();

		boolean[] states = new boolean[n];
		for (int i = 0; i < states.length; i++) {
			states[i] = s.charAt(i) == '1';
		}

		int result = (int) IntStream.range(0, n).filter(i -> states[i]).count();
		for (int step = 0; step < LIMIT; step++) {
			for (int i = 0; i < n; i++) {
				b[i]--;

				if (b[i] == 0) {
					states[i] = !states[i];

					b[i] = a[i];
				}
			}

			result = Math.max(result, (int) IntStream.range(0, n).filter(i -> states[i]).count());
		}

		return result;
	}
}
