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
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (!stack.empty() && ch == stack.peek()) {
				stack.pop();
			} else {
				stack.push(ch);
			}
		}

		return stack.empty();
	}
}
