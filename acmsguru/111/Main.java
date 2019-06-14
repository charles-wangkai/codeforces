import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigInteger X = sc.nextBigInteger();
		System.out.println(solve(X));

		sc.close();
	}

	static BigInteger solve(BigInteger X) {
		BigInteger result = null;
		BigInteger lower = BigInteger.ONE;
		BigInteger upper = X;
		while (lower.compareTo(upper) <= 0) {
			BigInteger middle = lower.add(upper).divide(BigInteger.valueOf(2));

			if (middle.multiply(middle).compareTo(X) <= 0) {
				result = middle;

				lower = middle.add(BigInteger.ONE);
			} else {
				upper = middle.subtract(BigInteger.ONE);
			}
		}
		return result;
	}
}
