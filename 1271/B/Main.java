import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		int countB = (int) s.chars().filter(ch -> ch == 'B').count();
		int countW = s.length() - countB;

		if (countB % 2 != 0 && countW % 2 != 0) {
			return "-1";
		}

		char target = (countB % 2 == 0) ? 'B' : 'W';

		char[] blocks = s.toCharArray();
		List<Integer> p = new ArrayList<>();
		for (int i = 0; i < blocks.length - 1; ++i) {
			if (blocks[i] == target) {
				blocks[i] = invert(blocks[i]);
				blocks[i + 1] = invert(blocks[i + 1]);

				p.add(i + 1);
			}
		}

		return String.format("%d\n%s", p.size(), p.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}

	static char invert(char block) {
		return (char) ('B' + 'W' - block);
	}
}
