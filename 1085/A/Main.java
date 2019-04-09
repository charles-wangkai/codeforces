import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String t = sc.next();
		System.out.println(solve(t));

		sc.close();
	}

	static String solve(String t) {
		int leftIndex = 0;
		int rightIndex = t.length() - 1;
		boolean leftOrRight = t.length() % 2 != 0;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < t.length(); i++) {
			if (leftOrRight) {
				result.append(t.charAt(leftIndex));
				leftIndex++;
			} else {
				result.append(t.charAt(rightIndex));
				rightIndex--;
			}

			leftOrRight = !leftOrRight;
		}
		return result.reverse().toString();
	}
}
