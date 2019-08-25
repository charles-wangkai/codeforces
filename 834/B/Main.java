import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int k = sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s, k) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String s, int k) {
		int n = s.length();

		boolean[] firsts = new boolean[n];
		boolean[] lasts = new boolean[n];
		s.chars().distinct().forEach(ch -> {
			firsts[s.indexOf(ch)] = true;
			lasts[s.lastIndexOf(ch)] = true;
		});

		int openNum = 0;
		for (int i = 0; i < n; i++) {
			if (firsts[i]) {
				openNum++;

				if (openNum > k) {
					return true;
				}
			}

			if (lasts[i]) {
				openNum--;
			}
		}

		return false;
	}
}
