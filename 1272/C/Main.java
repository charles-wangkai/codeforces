import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int k = sc.nextInt();
		String s = sc.next();
		Set<Character> c = new HashSet<>();
		for (int i = 0; i < k; i++) {
			c.add(sc.next().charAt(0));
		}
		System.out.println(solve(s, c));

		sc.close();
	}

	static long solve(String s, Set<Character> c) {
		long result = 0;
		int count = 0;
		for (int i = 0; i <= s.length(); i++) {
			if (i != s.length() && c.contains(s.charAt(i))) {
				count++;
			} else {
				result += count * (count + 1L) / 2;
				count = 0;
			}
		}

		return result;
	}
}
