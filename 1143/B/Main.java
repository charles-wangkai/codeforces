import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		String s = String.valueOf(n);

		int result = computeDigitProduct(n);
		for (int prefixLength = 1; prefixLength <= s.length(); prefixLength++) {
			result = Math.max(result,
					Math.max(1, computeDigitProduct(Integer.parseInt(s.substring(0, prefixLength)) - 1))
							* pow(9, s.length() - prefixLength));
		}

		return result;
	}

	static int pow(int base, int exponent) {
		return IntStream.range(0, exponent).reduce(1, (result, element) -> result * base);
	}

	static int computeDigitProduct(int x) {
		return String.valueOf(x).chars().map(ch -> ch - '0').reduce(1, (result, element) -> result * element);
	}
}
