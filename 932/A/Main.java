import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String A = sc.next();
		System.out.println(solve(A));

		sc.close();
	}

	static String solve(String A) {
		return String.format("%s%s", A, new StringBuilder(A).reverse().toString());
	}
}
