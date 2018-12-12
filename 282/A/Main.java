import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] statements = new String[n];
		for (int i = 0; i < statements.length; i++) {
			statements[i] = sc.next();
		}
		System.out.println(solve(statements));

		sc.close();
	}

	static int solve(String[] statements) {
		int result = 0;
		for (String statement : statements) {
			if (statement.charAt(1) == '+') {
				result++;
			} else {
				result--;
			}
		}
		return result;
	}
}
