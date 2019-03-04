import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String t = sc.next();
		System.out.println(solve(s, t));

		sc.close();
	}

	static int solve(String s, String t) {
		int index = 0;
		for (char instruction : t.toCharArray()) {
			if (s.charAt(index) == instruction) {
				index++;
			}
		}
		return index + 1;
	}
}
