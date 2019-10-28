import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			String s = sc.next();

			System.out.println(solve(s));
		}

		sc.close();
	}

	static String solve(String s) {
		Set<Character> workings = new HashSet<>();

		char prev = 0;
		int count = 0;
		for (int i = 0; i <= s.length(); i++) {
			if (i != s.length() && s.charAt(i) == prev) {
				count++;
			} else {
				if (count % 2 != 0) {
					workings.add(prev);
				}

				if (i != s.length()) {
					prev = s.charAt(i);
					count = 1;
				}
			}
		}

		return workings.stream().sorted().map(String::valueOf).collect(Collectors.joining());
	}
}
