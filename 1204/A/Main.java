import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		return (s.length() + 1) / 2
				- ((s.length() % 2 != 0 && (s.length() == 1 || s.substring(1).chars().allMatch(ch -> ch == '0'))) ? 1
						: 0);
	}
}
