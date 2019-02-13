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
		StringBuilder result = new StringBuilder();
		int index = 0;
		int step = 1;
		while (index < s.length()) {
			result.append(s.charAt(index));

			index += step;
			step++;
		}
		return result.toString();
	}
}
