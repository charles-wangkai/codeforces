import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
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
		Set<Integer> digits1 = number1.chars().boxed().collect(Collectors.toSet());

		int total = (int) number2.chars().filter(digits1::contains).count();

		int bulls = (int) IntStream.range(0, number1.length()).filter(i -> number1.charAt(i) == number2.charAt(i))
				.count();
		int cows = total - bulls;

		return String.format("%d %d", bulls, cows);
	}
}
