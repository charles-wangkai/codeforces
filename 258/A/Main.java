import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		System.out.println(solve(a));

		sc.close();
	}

	static String solve(String a) {
		int index = a.indexOf("01");

		return (index >= 0) ? (a.substring(0, index) + a.substring(index + 1)) : a.substring(0, a.length() - 1);
	}
}
