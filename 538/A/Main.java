import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final String TARGET = "CODEFORCES";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String banner = sc.next();
		System.out.println(solve(banner) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String banner) {
		return IntStream.rangeClosed(0, TARGET.length())
				.anyMatch(prefixLength -> banner.startsWith(TARGET.substring(0, prefixLength))
						&& banner.endsWith(TARGET.substring(prefixLength)));
	}
}
