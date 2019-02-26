import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int k = sc.nextInt();
		int[] w = new int[26];
		for (int i = 0; i < w.length; i++) {
			w[i] = sc.nextInt();
		}
		System.out.println(solve(s, k, w));

		sc.close();
	}

	static int solve(String s, int k, int[] w) {
		return IntStream.range(0, s.length()).map(i -> (i + 1) * w[s.charAt(i) - 'a']).sum()
				+ (s.length() + 1 + s.length() + k) * k / 2 * Arrays.stream(w).max().getAsInt();
	}
}
