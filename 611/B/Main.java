import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		System.out.println(solve(a, b));

		sc.close();
	}

	static int solve(long a, long b) {
		return IntStream.rangeClosed(1, 60).map(length -> (int) IntStream.range(1, length).filter(zeroIndex -> {
			long year = buildYear(length, zeroIndex);

			return year >= a && year <= b;
		}).count()).sum();
	}

	static long buildYear(int length, int zeroIndex) {
		long result = 0;
		for (int i = 0; i < length; i++) {
			result *= 2;

			if (i != zeroIndex) {
				result++;
			}
		}

		return result;
	}
}
