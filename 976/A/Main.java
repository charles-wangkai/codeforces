import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		return s.equals("0") ? "0" : String.format("1%s", repeat('0', (int) s.chars().filter(ch -> ch == '0').count()));
	}

	static String repeat(char ch, int count) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < count; i++) {
			result.append(ch);
		}
		return result.toString();
	}
}
