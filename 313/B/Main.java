import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int m = sc.nextInt();
		int[] l = new int[m];
		int[] r = new int[m];
		for (int i = 0; i < m; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		Arrays.stream(solve(s, l, r)).forEach(System.out::println);

		sc.close();
	}

	static int[] solve(String s, int[] l, int[] r) {
		int[] prefixSums = new int[s.length()];
		int prefixSum = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				prefixSum++;
			}

			prefixSums[i + 1] = prefixSum;
		}

		int[] result = new int[l.length];
		for (int i = 0; i < l.length; i++) {
			result[i] = prefixSums[r[i] - 1] - prefixSums[l[i] - 1];
		}
		return result;
	}
}
