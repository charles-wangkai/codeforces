import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int k = sc.nextInt();
		String S = sc.next();
		System.out.println(solve(S, k));

		sc.close();
	}

	static String solve(String S, int k) {
		StringBuilder result = new StringBuilder();
		for (char ch : S.toCharArray()) {
			char target = (result.length() == 0 && S.length() != 1) ? '1' : '0';

			if (ch == target) {
				result.append(ch);
			} else {
				if (k != 0) {
					result.append(target);
					k--;
				} else {
					result.append(ch);
				}
			}
		}

		return result.toString();
	}
}
