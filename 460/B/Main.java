import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.print(solve(a, b, c));

		sc.close();
	}

	static String solve(int a, int b, int c) {
		List<Integer> solutions = new ArrayList<>();
		for (int sx = 1; sx <= 81; sx++) {
			long x = pow(sx, a) * b + c;

			if (x > 0 && x < 1_000_000_000 && computeDigitSum(x) == sx) {
				solutions.add((int) x);
			}
		}

		Collections.sort(solutions);

		return String.format("%d\n%s", solutions.size(),
				solutions.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}

	static long pow(int base, int exponent) {
		long result = 1;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}

	static int computeDigitSum(long x) {
		return String.valueOf(x).chars().map(ch -> ch - '0').sum();
	}
}
