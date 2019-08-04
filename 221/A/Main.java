import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		return String.format("%d %s", n,
				IntStream.range(1, n).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}
}
