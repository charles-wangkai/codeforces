import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		sc.nextInt();
		String horizontal = sc.next();
		String vertical = sc.next();
		System.out.println(solve(horizontal, vertical) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String horizontal, String vertical) {
		char top = horizontal.charAt(0);
		char down = horizontal.charAt(horizontal.length() - 1);
		char left = vertical.charAt(0);
		char right = vertical.charAt(vertical.length() - 1);

		return top != down && left != right && ((top == '>' && left == '^') || (top == '<' && left == 'v'));
	}
}
