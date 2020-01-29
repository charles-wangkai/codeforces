import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static long solve(String s) {
		long result = 0;
		for (int i = 0; i < s.length(); ++i) {
			if ((s.charAt(i) - '0') % 4 == 0) {
				++result;
			}

			if (i != 0 && Integer.parseInt(s.substring(i - 1, i + 1)) % 4 == 0) {
				result += i;
			}
		}

		return result;
	}
}
