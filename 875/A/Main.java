import java.util.Arrays;
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
		int[] xs = IntStream.range(Math.max(1, n - 81), n)
				.filter(x -> x + String.valueOf(x).chars().map(ch -> ch - '0').sum() == n).toArray();

		return String.format("%d\n%s", xs.length,
				Arrays.stream(xs).mapToObj(String::valueOf).collect(Collectors.joining("\n")));
	}
}
