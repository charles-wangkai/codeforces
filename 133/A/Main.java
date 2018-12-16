import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String p = sc.next();
		System.out.println(solve(p) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String p) {
		return p.contains("H") || p.contains("Q") || p.contains("9");
	}
}
