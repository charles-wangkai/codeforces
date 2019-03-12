import java.util.Scanner;

public class Main {
	static final String[] ONE_WORDS = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine" };
	static final String[] TEEN_WORDS = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "eighteen", "nineteen" };
	static final String[] TEN_WORDS = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(int s) {
		if (s < 10) {
			return ONE_WORDS[s];
		} else if (s < 20) {
			return TEEN_WORDS[s - 10];
		} else if (s % 10 == 0) {
			return TEN_WORDS[s / 10 - 2];
		} else {
			return String.format("%s-%s", TEN_WORDS[s / 10 - 2], ONE_WORDS[s % 10]);
		}
	}
}
