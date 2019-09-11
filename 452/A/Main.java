import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		return Stream.of("vaporeon", "jolteon", "flareon", "espeon", "umbreon", "leafeon", "glaceon", "sylveon")
				.filter(name -> name.length() == s.length() && IntStream.range(0, s.length())
						.allMatch(i -> s.charAt(i) == '.' || s.charAt(i) == name.charAt(i)))
				.findAny().get();
	}
}
