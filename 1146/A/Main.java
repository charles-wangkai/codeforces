import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		return Math.min(s.length(), (int) s.chars().filter(ch -> ch == 'a').count() * 2 - 1);
	}
}
