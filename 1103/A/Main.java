import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.print(solve(s));

		sc.close();
	}

	static String solve(String s) {
		StringBuilder result = new StringBuilder();
		int count0 = 0;
		int count1 = 0;
		for (char ch : s.toCharArray()) {
			int r;
			int c;
			if (ch == '0') {
				count0++;

				r = 1;
				c = (count0 - 1) % 4 + 1;

			} else {
				count1++;

				r = 3;
				c = (count1 - 1) % 2 * 2 + 1;
			}

			result.append(String.format("%d %d\n", r, c));
		}
		return result.toString();
	}
}
