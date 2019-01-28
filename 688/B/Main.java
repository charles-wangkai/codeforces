import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String n = sc.next();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(String n) {
		return n + new StringBuilder(n).reverse().toString();
	}
}
