import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		String digits = sc.next();
		System.out.println(solve(digits, x, y));

		sc.close();
	}

	static int solve(String digits, int x, int y) {
		return (int) IntStream.range(0, x).filter(i -> digits.charAt(digits.length() - 1 - i) != ((i == y) ? '1' : '0'))
				.count();
	}
}
