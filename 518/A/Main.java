import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String t = sc.next();
		System.out.println(solve(s, t));

		sc.close();
	}

	static String solve(String s, String t) {
		int index = s.length() - 1;
		while (s.charAt(index) == 'z') {
			index--;
		}

		StringBuilder result = new StringBuilder(s.substring(0, index)).append((char) (s.charAt(index) + 1));
		while (result.length() != s.length()) {
			result.append('a');
		}

		return result.toString().equals(t) ? "No such string" : result.toString();
	}
}
