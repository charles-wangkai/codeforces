import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] u = new int[m];
		int[] v = new int[m];
		int[] l = new int[m];
		for (int i = 0; i < m; i++) {
			u[i] = sc.nextInt();
			v[i] = sc.nextInt();
			l[i] = sc.nextInt();
		}
		int[] a = new int[k];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(u, v, l, a));

		sc.close();
	}

	static int solve(int[] u, int[] v, int[] l, int[] a) {
		Set<Integer> storages = Arrays.stream(a).boxed().collect(Collectors.toSet());

		return IntStream.range(0, u.length).filter(i -> storages.contains(u[i]) != storages.contains(v[i]))
				.map(i -> l[i]).min().orElse(-1);
	}
}
