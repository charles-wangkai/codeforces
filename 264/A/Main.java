import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		Deque<Integer> result = new LinkedList<>();
		result.add(s.length());
		for (int i = s.length() - 1; i >= 1; i--) {
			if (s.charAt(i - 1) == 'l') {
				result.addLast(i);
			} else {
				result.addFirst(i);
			}
		}

		return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
	}
}
