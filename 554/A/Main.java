import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		return (int) IntStream.rangeClosed(0, s.length()).boxed()
				.flatMap(i -> IntStream.rangeClosed('a', 'z')
						.mapToObj(ch -> String.format("%s%c%s", s.substring(0, i), ch, s.substring(i))))
				.distinct().count();
	}
}
