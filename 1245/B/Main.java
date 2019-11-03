import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			String s = sc.next();

			System.out.println(solve(a, b, c, s));
		}

		sc.close();
	}

	static String solve(int a, int b, int c, String s) {
		int beatByR = Math.min(a, count(s, 'S'));
		int beatByP = Math.min(b, count(s, 'R'));
		int beatByS = Math.min(c, count(s, 'P'));

		if ((beatByR + beatByP + beatByS) * 2 < s.length()) {
			return "NO";
		}

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < a - beatByR; i++) {
			stack.push('R');
		}
		for (int i = 0; i < b - beatByP; i++) {
			stack.push('P');
		}
		for (int i = 0; i < c - beatByS; i++) {
			stack.push('S');
		}

		StringBuilder sequence = new StringBuilder();
		for (char bobHand : s.toCharArray()) {
			if (bobHand == 'S') {
				if (beatByR != 0) {
					sequence.append('R');
					beatByR--;
				} else {
					sequence.append(stack.pop());
				}
			} else if (bobHand == 'R') {
				if (beatByP != 0) {
					sequence.append('P');
					beatByP--;
				} else {
					sequence.append(stack.pop());
				}
			} else {
				if (beatByS != 0) {
					sequence.append('S');
					beatByS--;
				} else {
					sequence.append(stack.pop());
				}
			}
		}

		return String.format("YES\n%s", sequence);
	}

	static int count(String s, char target) {
		return (int) s.chars().filter(ch -> ch == target).count();
	}
}
