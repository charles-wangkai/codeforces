import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		int count1 = (int) s.chars().filter(ch -> ch == '1').count();
		String remaining = s.chars().filter(ch -> ch != '1').mapToObj(ch -> (char) ch)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();

		int index = 0;
		while (index != remaining.length() && remaining.charAt(index) == '0') {
			index++;
		}

		return String.format("%s%s%s", remaining.substring(0, index), repeat('1', count1), remaining.substring(index));
	}

	static String repeat(char ch, int count) {
		return IntStream.range(0, count).mapToObj(i -> ch)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}
}
