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
		return IntStream.range(0, n)
				.mapToObj(r -> IntStream.range(0, n).mapToObj(c -> ((r + c) % 2 == 0) ? 'W' : 'B')
						.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString())
				.collect(Collectors.joining("\n"));
	}
}
