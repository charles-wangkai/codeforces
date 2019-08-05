import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int p = sc.nextInt();
		int q = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		int[] a = new int[p];
		int[] b = new int[p];
		for (int i = 0; i < p; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		int[] c = new int[q];
		int[] d = new int[q];
		for (int i = 0; i < q; i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		System.out.println(solve(a, b, c, d, l, r));

		sc.close();
	}

	static int solve(int[] a, int[] b, int[] c, int[] d, int l, int r) {
		Set<Integer> zSchedule = IntStream.range(0, a.length).flatMap(i -> IntStream.rangeClosed(a[i], b[i])).boxed()
				.collect(Collectors.toSet());

		return (int) IntStream.rangeClosed(l, r)
				.filter(t -> hasCommon(IntStream.range(0, c.length).flatMap(i -> IntStream.rangeClosed(c[i], d[i]))
						.map(x -> x + t).boxed().collect(Collectors.toSet()), zSchedule))
				.count();
	}

	static boolean hasCommon(Set<Integer> xSchedule, Set<Integer> zSchedule) {
		return xSchedule.stream().anyMatch(zSchedule::contains);
	}
}
