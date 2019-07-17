import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		String t = sc.next();
		System.out.println(solve(s, t));

		sc.close();
	}

	static String solve(String s, String t) {
		StringBuilder str = new StringBuilder(s);
		List<Integer> indices = new ArrayList<>();

		for (int i = 0; i < t.length(); i++) {
			int index = str.indexOf(t.substring(i, i + 1), i);
			if (index == -1) {
				return "-1";
			}

			for (int j = index - 1; j >= i; j--) {
				char temp = str.charAt(j);
				str.setCharAt(j, str.charAt(j + 1));
				str.setCharAt(j + 1, temp);

				indices.add(j + 1);
			}
		}

		return String.format("%d\n%s", indices.size(),
				indices.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}
