import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			String s = sc.next();
			String t = sc.next();

			System.out.println(solve(s, t) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(String s, String t) {
		Set<Integer> set = s.chars().boxed().collect(Collectors.toSet());

		return t.chars().anyMatch(set::contains);
	}
}
