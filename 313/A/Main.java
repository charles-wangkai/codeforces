import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		if (n >= 0) {
			return n;
		}

		String s = String.valueOf(n);
		if (s.length() == 2) {
			return 0;
		} else {
			return Math.max(Integer.parseInt(s.substring(0, s.length() - 1)),
					Integer.parseInt(s.substring(0, s.length() - 2) + s.charAt(s.length() - 1)));
		}
	}
}
