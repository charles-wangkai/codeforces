import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		if (n % 2 != 0) {
			return "-1";
		}

		return String.join(" ", IntStream.range(0, n).map(i -> i + (i % 2 == 0 ? 2 : 0)).mapToObj(String::valueOf)
				.toArray(String[]::new));
	}
}
