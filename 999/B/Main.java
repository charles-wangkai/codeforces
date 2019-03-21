import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		StringBuilder result = new StringBuilder(s);
		for (int i = 1; i <= result.length(); i++) {
			if (s.length() % i == 0) {
				for (int left = 0, right = i - 1; left < right; left++, right--) {
					char temp = result.charAt(left);
					result.setCharAt(left, result.charAt(right));
					result.setCharAt(right, temp);
				}
			}
		}
		return result.toString();
	}
}
