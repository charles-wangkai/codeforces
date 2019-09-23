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
		StringBuilder modified = new StringBuilder();
		int operationCount = 0;
		for (int i = 0; i < s.length(); i += 2) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				modified.append("ab");
				operationCount++;
			} else {
				modified.append(s.substring(i, i + 2));
			}
		}

		return String.format("%d\n%s", operationCount, modified);
	}
}
