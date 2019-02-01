import java.util.Collections;
import java.util.Scanner;

public class Main {
	static final String[] EXPANSIONS = { "", "", "2", "3", "223", "5", "35", "7", "2227", "2337" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String a = sc.next();
		System.out.println(solve(a));

		sc.close();
	}

	static String solve(String a) {
		return String.join("",
				String.join("", a.chars().mapToObj(ch -> EXPANSIONS[ch - '0']).toArray(String[]::new)).chars().boxed()
						.sorted(Collections.reverseOrder()).map(ch -> String.valueOf((char) ch.intValue()))
						.toArray(String[]::new));
	}
}
