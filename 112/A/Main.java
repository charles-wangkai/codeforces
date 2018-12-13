import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(solve(s1, s2));

		sc.close();
	}

	static int solve(String s1, String s2) {
		return (int) Math.signum(s1.compareToIgnoreCase(s2));
	}
}
