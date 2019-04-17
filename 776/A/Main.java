import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String candidate1 = sc.next();
		String candidate2 = sc.next();
		int n = sc.nextInt();
		String[] victims = new String[n];
		String[] replacements = new String[n];
		for (int i = 0; i < n; i++) {
			victims[i] = sc.next();
			replacements[i] = sc.next();
		}
		System.out.println(solve(candidate1, candidate2, victims, replacements));

		sc.close();
	}

	static String solve(String candidate1, String candidate2, String[] victims, String[] replacements) {
		StringBuilder result = new StringBuilder(String.format("%s %s", candidate1, candidate2));
		for (int i = 0; i < victims.length; i++) {
			if (victims[i].equals(candidate1)) {
				candidate1 = replacements[i];
			} else {
				candidate2 = replacements[i];
			}

			result.append(String.format("\n%s %s", candidate1, candidate2));
		}
		return result.toString();
	}
}
