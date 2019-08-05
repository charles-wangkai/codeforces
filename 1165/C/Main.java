import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.print(solve(s));

		sc.close();
	}

	static String solve(String s) {
		StringBuilder deleted = new StringBuilder();
		int index = 0;
		while (index + 1 < s.length()) {
			char ch = s.charAt(index);
			char ch1 = s.charAt(index + 1);

			if (ch != ch1) {
				deleted.append(ch).append(ch1);
				index += 2;
			} else if (index + 2 < s.length() && ch != s.charAt(index + 2)) {
				deleted.append(ch).append(s.charAt(index + 2));
				index += 3;
			} else {
				index += 2;
			}
		}

		return String.format("%d\n%s", s.length() - deleted.length(), deleted.toString());
	}
}
