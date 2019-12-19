import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			String p = sc.next();
			String h = sc.next();

			System.out.println(solve(p, h) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(String p, String h) {
		return IntStream.range(0, h.length() - p.length() + 1)
				.anyMatch(i -> buildKey(p).equals(buildKey(h.substring(i, i + p.length()))));
	}

	static String buildKey(String s) {
		return s.chars().sorted().mapToObj(ch -> (char) ch)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}
}
