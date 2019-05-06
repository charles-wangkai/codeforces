import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(String s) {
		int moveNum = 0;
		Stack<Character> stack = new Stack<>();
		for (char letter : s.toCharArray()) {
			if (!stack.empty() && stack.peek() == letter) {
				stack.pop();

				moveNum++;
			} else {
				stack.push(letter);
			}
		}
		return moveNum % 2 != 0;
	}
}
