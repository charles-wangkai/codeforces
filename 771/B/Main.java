import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		String[] s = new String[n - k + 1];
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.next();
		}
		System.out.println(solve(n, k, s));

		sc.close();
	}

	static String solve(int n, int k, String[] s) {
		int[] numbers = IntStream.rangeClosed(1, n).toArray();
		for (int i = k - 1; i < numbers.length; i++) {
			if (s[i - k + 1].equals("NO")) {
				numbers[i] = numbers[i - k + 1];
			}
		}

		return Arrays.stream(numbers).mapToObj(Main::generateName).collect(Collectors.joining(" "));
	}

	static String generateName(int number) {
		StringBuilder result = new StringBuilder();
		while (number != 0) {
			result.append((char) (number % 26 + ((result.length() == 0) ? 'A' : 'a')));

			number /= 26;
		}

		return result.toString();
	}
}
