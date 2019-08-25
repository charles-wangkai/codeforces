import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.print(solve(n));

		sc.close();
	}

	static String solve(int n) {
		int m = n / 2 + 1;

		return String.format("%d\n%s", m,
				IntStream.range(0, n).mapToObj(i -> String.format("%d %d", Math.max(1, i - m + 2), Math.min(m, i + 1)))
						.collect(Collectors.joining("\n")));
	}
}
