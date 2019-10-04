import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		int leftLength = 0;
		while (leftLength < s.length() && s.charAt(leftLength) == '<') {
			leftLength++;
		}

		int rightLength = 0;
		while (rightLength < s.length() && s.charAt(s.length() - 1 - rightLength) == '>') {
			rightLength++;
		}

		return leftLength + rightLength;
	}
}
