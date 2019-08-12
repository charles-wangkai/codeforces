import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		sc.nextInt();
		int q = sc.nextInt();
		String s = sc.next();
		String t = sc.next();
		int[] l = new int[q];
		int[] r = new int[q];
		for (int i = 0; i < q; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		System.out.println(solve(s, t, l, r));

		sc.close();
	}

	static String solve(String s, String t, int[] l, int[] r) {
		int[] beginIndices = IntStream.range(0, s.length()).filter(i -> s.startsWith(t, i)).toArray();

		return IntStream.range(0, l.length)
				.mapToObj(i -> String.valueOf(Arrays.stream(beginIndices)
						.filter(beginIndex -> beginIndex >= l[i] - 1 && beginIndex + t.length() <= r[i]).count()))
				.collect(Collectors.joining("\n"));
	}
}
