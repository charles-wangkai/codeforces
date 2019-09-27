import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int d = sc.nextInt();
		System.out.println(solve(k, d));

		sc.close();
	}

	static String solve(int k, int d) {
		if (d == 0 && k != 1) {
			return "No solution";
		}

		return String.format("%d%s", d, IntStream.range(0, k - 1).map(i -> 0)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());
	}
}
