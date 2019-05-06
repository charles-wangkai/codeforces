import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();
		System.out.println(solve(a, b));

		sc.close();
	}

	static String solve(String a, String b) {
		return a.equals(b) ? a : "1";
	}
}
