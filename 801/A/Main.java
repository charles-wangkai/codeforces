import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		int count = 0;
		boolean canIncrease = false;

		for (int i = 0; i < s.length(); i++) {
			if (i != s.length() - 1 && s.substring(i, i + 2).equals("VK")) {
				count++;
			}

			if (s.charAt(i) == 'V') {
				if (!(i != s.length() - 1 && s.charAt(i + 1) == 'K') && i != 0 && s.charAt(i - 1) == 'V') {
					canIncrease = true;
				}
			} else {
				if (!(i != 0 && s.charAt(i - 1) == 'V') && i != s.length() - 1 && s.charAt(i + 1) == 'K') {
					canIncrease = true;
				}
			}
		}

		return count + (canIncrease ? 1 : 0);
	}
}
