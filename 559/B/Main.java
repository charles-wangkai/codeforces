import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(solve(s1, s2) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String s1, String s2) {
		return buildKey(s1).equals(buildKey(s2));
	}

	static String buildKey(String s) {
		if (s.length() % 2 != 0) {
			return s;
		}

		int halfLength = s.length() / 2;
		String partKey1 = buildKey(s.substring(0, halfLength));
		String partKey2 = buildKey(s.substring(halfLength));

		if (partKey1.compareTo(partKey2) <= 0) {
			return String.format("%s%s", partKey1, partKey2);
		} else {
			return String.format("%s%s", partKey2, partKey1);
		}
	}
}
