package A;
import java.util.ArrayList;
import java.util.List;
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
		List<String> substrings = new ArrayList<>();
		if (isGood(s)) {
			substrings.add(s);
		} else {
			substrings.add(s.substring(0, 1));
			substrings.add(s.substring(1));
		}

		return String.format("%d\n%s", substrings.size(), String.join(" ", substrings));
	}

	static boolean isGood(String s) {
		return s.chars().filter(ch -> ch == '0').count() * 2 != s.length();
	}
}
