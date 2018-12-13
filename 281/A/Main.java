import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.next();
		System.out.println(solve(word));

		sc.close();
	}

	static String solve(String word) {
		return Character.toUpperCase(word.charAt(0)) + word.substring(1);
	}
}
