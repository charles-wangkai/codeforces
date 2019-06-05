import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			sc.nextInt();
			String s = sc.next();

			System.out.println(solve(s));
		}

		sc.close();
	}

	static int solve(String s) {
		int result = Integer.MAX_VALUE;

		int leftIndex = s.indexOf('>');
		if (leftIndex >= 0) {
			result = Math.min(result, leftIndex);
		}

		int rightIndex = s.lastIndexOf('<');
		if (rightIndex >= 0) {
			result = Math.min(result, s.length() - 1 - rightIndex);
		}

		return result;
	}
}
