import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < c.length; ++i) {
			c[i] = sc.nextInt();
		}
		int[] a = new int[m];
		int[] b = new int[m];
		for (int i = 0; i < m; ++i) {
			a[i] = sc.nextInt() - 1;
			b[i] = sc.nextInt() - 1;
		}
		System.out.println(solve(c, a, b));

		sc.close();
	}

	static int solve(int[] c, int[] a, int[] b) {
		Map<Integer, Set<Integer>> colorToAdjs = Arrays.stream(c).distinct().boxed()
				.collect(Collectors.toMap(Function.identity(), color -> {
					Set<Integer> adjs = new HashSet<>();
					adjs.add(color);

					return adjs;
				}));

		for (int i = 0; i < a.length; ++i) {
			int color1 = c[a[i]];
			int color2 = c[b[i]];

			colorToAdjs.get(color1).add(color2);
			colorToAdjs.get(color2).add(color1);
		}

		int maxAdjsSize = colorToAdjs.values().stream().mapToInt(Set::size).max().getAsInt();

		return colorToAdjs.keySet().stream().filter(color -> colorToAdjs.get(color).size() == maxAdjsSize)
				.mapToInt(x -> x).min().getAsInt();
	}
}
