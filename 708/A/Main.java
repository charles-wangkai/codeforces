import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		int beginIndex = 0;
		while (beginIndex < s.length() && s.charAt(beginIndex) == 'a') {
			beginIndex++;
		}

		if (beginIndex == s.length()) {
			return String.format("%sz", s.substring(0, s.length() - 1));
		}

		int endIndex = beginIndex;
		while (endIndex < s.length() && s.charAt(endIndex) != 'a') {
			endIndex++;
		}

		return String.format("%s%s%s", s.substring(0, beginIndex),
				s.substring(beginIndex, endIndex).chars().mapToObj(ch -> (char) (ch - 1))
						.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString(),
				s.substring(endIndex));
	}
}
