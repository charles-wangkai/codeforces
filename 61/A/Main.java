import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String number1 = sc.next();
		String number2 = sc.next();
		System.out.println(solve(number1, number2));

		sc.close();
	}

	static String solve(String number1, String number2) {
		return IntStream.range(0, number1.length()).map(i -> (number1.charAt(i) != number2.charAt(i)) ? 1 : 0)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}
}
