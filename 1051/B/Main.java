import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long l = sc.nextLong();
		long r = sc.nextLong();
		System.out.println(solve(l, r));

		sc.close();
	}

	static String solve(long l, long r) {
		return String.format("YES\n%s", IntStream.range(0, (int) ((r - l + 1) / 2))
				.mapToObj(i -> String.format("%d %d", l + i * 2, l + i * 2 + 1)).collect(Collectors.joining("\n")));
	}
}
