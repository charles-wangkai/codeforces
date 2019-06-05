import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.print(solve(n, m));

		sc.close();
	}

	static String solve(int n, int m) {
		int k = Math.min(n, m) + 1;

		return String.format("%d\n%s", k, IntStream.range(0, k).mapToObj(i -> String.format("%d %d", i, k - 1 - i))
				.collect(Collectors.joining("\n")));
	}
}
