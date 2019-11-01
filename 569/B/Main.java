import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
		int n = a.length;

		boolean[] used = new boolean[n + 1];
		for (int ai : a) {
			if (ai < used.length) {
				used[ai] = true;
			}
		}

		int[] unused = IntStream.rangeClosed(1, n).filter(i -> !used[i]).toArray();
		int unusedIndex = 0;
		Arrays.fill(used, false);
		int[] result = new int[n];
		for (int i = 0; i < result.length; i++) {
			if (a[i] >= used.length || used[a[i]]) {
				result[i] = unused[unusedIndex];
				unusedIndex++;
			} else {
				result[i] = a[i];
				used[a[i]] = true;
			}
		}

		return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}
}
