import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String t = sc.next();
		System.out.println(solve(s, t) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String s, String t) {
		return t.equals(new StringBuilder(s).reverse().toString());
	}
}
