import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int t = sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s, t));

		sc.close();
	}

	static String solve(String s, int t) {
		String current = s;
		for (int i = 0; i < t; i++) {
			StringBuilder next = new StringBuilder();
			int index = 0;
			while (index < current.length()) {
				if (index + 1 < current.length() && current.charAt(index) == 'B' && current.charAt(index + 1) == 'G') {
					next.append("GB");
					index += 2;
				} else {
					next.append(current.charAt(index));
					index++;
				}
			}

			current = next.toString();
		}
		return current;
	}
}
