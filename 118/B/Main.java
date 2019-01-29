import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.print(solve(n));

		sc.close();
	}

	static String solve(int n) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i <= n; i++) {
			result.append(buildLine(n, i)).append("\n");
		}
		for (int i = n - 1; i >= 0; i--) {
			result.append(buildLine(n, i)).append("\n");
		}
		return result.toString();
	}

	static String buildLine(int n, int centerDigit) {
		List<Character> cells = new ArrayList<>();

		for (int i = 0; i < n - centerDigit; i++) {
			cells.add(' ');
		}
		for (int i = 0; i <= centerDigit; i++) {
			cells.add((char) ('0' + i));
		}
		for (int i = centerDigit - 1; i >= 0; i--) {
			cells.add((char) ('0' + i));
		}

		return String.join(" ", cells.stream().map(String::valueOf).toArray(String[]::new));
	}
}
