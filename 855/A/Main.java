import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] s = new String[n];
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.next();
		}
		System.out.print(solve(s));

		sc.close();
	}

	static String solve(String[] s) {
		StringBuilder result = new StringBuilder();
		Set<String> history = new HashSet<>();
		for (String si : s) {
			if (history.contains(si)) {
				result.append("YES");
			} else {
				result.append("NO");
			}

			result.append("\n");
			history.add(si);
		}
		return result.toString();
	}
}
