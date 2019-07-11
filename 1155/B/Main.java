import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String s) {
		int round = (s.length() - 11) / 2;

		boolean[] erased = new boolean[s.length()];

		int index = 0;
		for (int i = 0; i < round; i++) {
			while (index < erased.length && s.charAt(index) == '8') {
				index++;
			}

			if (index == erased.length) {
				return true;
			}

			erased[index] = true;
			index++;
		}

		index = 0;
		for (int i = 0; i < round; i++) {
			while (index < erased.length && (erased[index] || s.charAt(index) != '8')) {
				index++;
			}

			if (index == erased.length) {
				return false;
			}

			erased[index] = true;
			index++;
		}

		for (int i = 0;; i++) {
			if (!erased[i]) {
				return s.charAt(i) == '8';
			}
		}
	}
}
