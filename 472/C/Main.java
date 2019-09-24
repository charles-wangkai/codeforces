import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] f = new String[n];
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
			f[i] = sc.next();
			s[i] = sc.next();
		}
		int[] p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();
		}
		System.out.println(solve(f, s, p) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String[] f, String[] s, int[] p) {
		String prev = "";
		for (int pi : p) {
			int index = pi - 1;

			String min;
			String max;
			if (f[index].compareTo(s[index]) <= 0) {
				min = f[index];
				max = s[index];
			} else {
				min = s[index];
				max = f[index];
			}

			if (prev.compareTo(min) <= 0) {
				prev = min;
			} else if (prev.compareTo(max) <= 0) {
				prev = max;
			} else {
				return false;
			}
		}

		return true;
	}
}
