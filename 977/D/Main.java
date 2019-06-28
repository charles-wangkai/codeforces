import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextLong();
		}
		System.out.println(Arrays.stream(solve(a)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

		sc.close();
	}

	static long[] solve(long[] a) {
		return Arrays.stream(a).mapToObj(Number::new)
				.sorted((number1, number2) -> (number1.exponentOfTwo != number2.exponentOfTwo)
						? Integer.compare(number1.exponentOfTwo, number2.exponentOfTwo)
						: Integer.compare(number2.exponentOfThree, number1.exponentOfThree))
				.mapToLong(number -> number.value).toArray();
	}
}

class Number {
	long value;
	int exponentOfTwo;
	int exponentOfThree;

	Number(long value) {
		this.value = value;
		this.exponentOfTwo = computeExponent(value, 2);
		this.exponentOfThree = computeExponent(value, 3);
	}

	int computeExponent(long value, int base) {
		int result = 0;
		while (value % base == 0) {
			value /= base;
			result++;
		}
		return result;
	}
}