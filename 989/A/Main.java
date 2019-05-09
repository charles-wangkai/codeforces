import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(String s) {
		return IntStream.range(0, s.length() - 2)
				.anyMatch(i -> s.subSequence(i, i + 3).chars().filter(ch -> ch != '.').distinct().count() == 3);
	}
}
