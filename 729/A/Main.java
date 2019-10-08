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
		while (index != s.length()) {
			if (s.startsWith("ogo", index)) {
				result.append("***");
				index += "ogo".length();

				while (s.startsWith("go", index)) {
					index += "go".length();
				}
			} else {
				result.append(s.charAt(index));
				index++;
			}
		}

		return result.toString();
	}
}
