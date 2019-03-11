import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int[][] REMAINDERS_LIST = { null, { 1 }, { 1, 2, 4, 3 }, { 1, 3, 4, 2 }, { 1, 4 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigInteger n = sc.nextBigInteger();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(BigInteger n) {
		return IntStream.rangeClosed(1, 4).map(x -> computeModulus(n, REMAINDERS_LIST[x])).sum() % 5;
	}

	static int computeModulus(BigInteger n, int[] remainders) {
		return remainders[n.mod(BigInteger.valueOf(remainders.length)).intValue()];
	}
}
