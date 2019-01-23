import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String name = sc.next();
		System.out.println(solve(name));

		sc.close();
	}

	static int solve(String name) {
		char pointer = 'a';
		int result = 0;
		for (char letter : name.toCharArray()) {
			int diff = Math.abs(letter - pointer);
			result += Math.min(diff, 26 - diff);

			pointer = letter;
		}
		return result;
	}
}
