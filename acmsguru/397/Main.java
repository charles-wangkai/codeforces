import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		List<Character> result = new LinkedList<>();
		ListIterator<Character> iter = result.listIterator();
		for (char ch : s.toCharArray()) {
			if (ch == 'L') {
				if (iter.hasPrevious()) {
					iter.previous();
				}
			} else if (ch == 'R') {
				if (iter.hasNext()) {
					iter.next();
				}
			} else {
				iter.add(ch);
			}
		}

		return result.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}
}
