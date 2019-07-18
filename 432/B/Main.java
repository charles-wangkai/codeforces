import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		System.out.print(solve(x, y));

		sc.close();
	}

	static String solve(int[] x, int[] y) {
		int n = x.length;

		Map<Integer, Integer> homeColorToCount = new HashMap<>();
		for (int homeColor : x) {
			homeColorToCount.put(homeColor, homeColorToCount.getOrDefault(homeColor, 0) + 1);
		}

		return IntStream.range(0, n).mapToObj(i -> {
			int home = n - 1 + homeColorToCount.getOrDefault(y[i], 0);
			int away = 2 * n - 2 - home;

			return String.format("%d %d", home, away);
		}).collect(Collectors.joining("\n"));
	}
}
