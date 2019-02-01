import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		return (int) s.chars().filter(ch -> "aeiou13579".indexOf(ch) >= 0).count();
	}
}
