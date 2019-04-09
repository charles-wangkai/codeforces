import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int tc = 0; tc < n; tc++) {
			String s = sc.next();

			System.out.println(solve(s) ? "Yes" : "No");
		}

		sc.close();
	}

	static boolean solve(String s) {
		int minCh = s.chars().min().getAsInt();
		int maxCh = s.chars().max().getAsInt();

		return maxCh - minCh + 1 == s.length()
				&& IntStream.rangeClosed(minCh, maxCh).allMatch(ch -> s.indexOf(ch) >= 0);
	}
}
