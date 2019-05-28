import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int k = sc.nextInt();
		String t = sc.next();
		System.out.println(solve(t, k));

		sc.close();
	}

	static String solve(String t, int k) {
		for (int i = 1;; i++) {
			String suffix = t.substring(i);

			if (t.startsWith(suffix)) {
				String prefix = t.substring(0, i);

				StringBuilder result = new StringBuilder();
				for (int j = 0; j < k - 1; j++) {
					result.append(prefix);
				}
				result.append(t);

				return result.toString();
			}
		}
	}
}
