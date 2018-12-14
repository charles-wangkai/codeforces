import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String name = sc.next();
		System.out.println(solve(name));

		sc.close();
	}

	static String solve(String name) {
		return (name.chars().distinct().count() % 2 == 0) ? "CHAT WITH HER!" : "IGNORE HIM!";
	}
}
