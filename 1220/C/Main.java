import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		char min = s.charAt(0);
		List<String> result = Stream.of("Mike").collect(Collectors.toList());

		for (int i = 1; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (min < ch) {
				result.add("Ann");
			} else {
				result.add("Mike");
				min = ch;
			}
		}

		return String.join("\n", result);
	}
}
