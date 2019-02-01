import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();
		System.out.println(solve(a, b));

		sc.close();
	}

	static int solve(String a, String b) {
		return a.equals(b) ? -1 : Math.max(a.length(), b.length());
	}
}
