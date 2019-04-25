import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int k = sc.nextInt();
		System.out.println(solve(s, k) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String s, int k) {
		return s.length() % k == 0 && IntStream.range(0, k).allMatch(i -> IntStream.range(0, s.length() / k)
				.allMatch(j -> s.charAt(i * (s.length() / k) + j) == s.charAt((i + 1) * (s.length() / k) - 1 - j)));
	}
}
