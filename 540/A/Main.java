import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String original = sc.next();
		String combination = sc.next();
		System.out.println(solve(original, combination));

		sc.close();
	}

	static int solve(String original, String combination) {
		return IntStream.range(0, original.length())
				.map(i -> computeDistance(original.charAt(i) - '0', combination.charAt(i) - '0')).sum();
	}

	static int computeDistance(int digit1, int digit2) {
		return Math.min(Math.abs(digit1 - digit2), 10 - Math.abs(digit1 - digit2));
	}
}
