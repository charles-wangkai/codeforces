import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		String s = sc.next();
		System.out.println(solve(a, s, k));

		sc.close();
	}

	static long solve(int[] a, String s, int k) {
		long result = 0;
		char current = 0;
		List<Integer> damages = new ArrayList<Integer>();
		for (int i = 0; i <= s.length(); i++) {
			if (i == s.length() || s.charAt(i) != current) {
				result += damages.stream().sorted(Collections.reverseOrder()).limit(k).mapToLong(x -> x).sum();

				damages.clear();
				if (i != s.length()) {
					current = s.charAt(i);
				}
			}

			if (i != s.length()) {
				damages.add(a[i]);
			}
		}

		return result;
	}
}
