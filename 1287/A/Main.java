import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			sc.nextInt();
			String s = sc.next();

			System.out.println(solve(s));
		}

		sc.close();
	}

	static int solve(String s) {
		int result = 0;
		int count = 0;
		for (int i = s.length() - 1; i >= 0; --i) {
			if (s.charAt(i) == 'P') {
				++count;
			} else {
				result = Math.max(result, count);
				count = 0;
			}
		}

		return result;
	}
}
