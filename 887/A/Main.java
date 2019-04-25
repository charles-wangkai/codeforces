import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s) ? "yes" : "no");

		sc.close();
	}

	static boolean solve(String s) {
		int zeroCount = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				zeroCount++;
			} else if (zeroCount >= 6) {
				return true;
			}
		}
		return false;
	}
}
