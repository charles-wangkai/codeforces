import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int m = sc.nextInt();
		String name = sc.next();
		char[] x = new char[m];
		char[] y = new char[m];
		for (int i = 0; i < m; i++) {
			x[i] = sc.next().charAt(0);
			y[i] = sc.next().charAt(0);
		}
		System.out.println(solve(name, x, y));

		sc.close();
	}

	static String solve(String name, char[] x, char[] y) {
		char[] newToOld = new char[26];
		for (int i = 0; i < newToOld.length; i++) {
			newToOld[i] = (char) ('a' + i);
		}

		for (int i = 0; i < x.length; i++) {
			int index1 = x[i] - 'a';
			int index2 = y[i] - 'a';

			char temp = newToOld[index1];
			newToOld[index1] = newToOld[index2];
			newToOld[index2] = temp;
		}

		Map<Character, Character> oldToNew = new HashMap<>();
		for (int i = 0; i < newToOld.length; i++) {
			oldToNew.put(newToOld[i], (char) ('a' + i));
		}

		return name.chars().mapToObj(ch -> oldToNew.get((char) ch))
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}
}
