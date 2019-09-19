import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.print(solve(s));

		sc.close();
	}

	static String solve(String s) {
		return IntStream
				.concat(IntStream.range(0, (int) s.chars().filter(ch -> ch == 'n').count()).map(i -> 1),
						IntStream.range(0, (int) s.chars().filter(ch -> ch == 'z').count()).map(i -> 0))
				.mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}
}
