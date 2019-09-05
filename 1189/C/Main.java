import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextInt();
		}
		int q = sc.nextInt();
		int[] l = new int[q];
		int[] r = new int[q];
		for (int i = 0; i < q; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		System.out.println(solve(s, l, r));

		sc.close();
	}

	static String solve(int[] s, int[] l, int[] r) {
		int[] prefixSums = new int[s.length + 1];
		int prefixSum = 0;
		for (int i = 1; i < prefixSums.length; i++) {
			prefixSum += s[i - 1];
			prefixSums[i] = prefixSum;
		}

		return IntStream.range(0, l.length)
				.mapToObj(i -> String.valueOf((prefixSums[r[i]] - prefixSums[l[i] - 1]) / 10))
				.collect(Collectors.joining("\n"));
	}
}
