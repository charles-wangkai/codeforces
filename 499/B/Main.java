import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		String[] a = new String[m];
		String[] b = new String[m];
		for (int i = 0; i < m; i++) {
			a[i] = sc.next();
			b[i] = sc.next();
		}
		String[] c = new String[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.next();
		}
		System.out.println(String.join(" ", solve(a, b, c)));

		sc.close();
	}

	static String[] solve(String[] a, String[] b, String[] c) {
		Map<String, String> firstToSecond = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			firstToSecond.put(a[i], b[i]);
		}

		String[] result = new String[c.length];
		for (int i = 0; i < result.length; i++) {
			String second = firstToSecond.get(c[i]);
			result[i] = (second.length() < c[i].length()) ? second : c[i];
		}
		return result;
	}
}
