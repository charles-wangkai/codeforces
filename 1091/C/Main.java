import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n).stream().map(String::valueOf).collect(Collectors.joining(" ")));

		sc.close();
	}

	static SortedSet<Long> solve(int n) {
		SortedSet<Long> result = new TreeSet<>();
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				result.add(computeFunValue(i, n / i));
				result.add(computeFunValue(n / i, i));
			}
		}
		return result;
	}

	static long computeFunValue(int step, int count) {
		return count + (count) * (count - 1L) / 2 * step;
	}
}
