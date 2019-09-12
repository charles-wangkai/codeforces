import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long l = sc.nextLong();
		long r = sc.nextLong();
		int k = sc.nextInt();
		System.out.print(solve(l, r, k));

		sc.close();
	}

	static String solve(long l, long r, int k) {
		List<Long> result = new ArrayList<>();
		BigInteger power = BigInteger.ONE;
		while (power.compareTo(BigInteger.valueOf(r)) <= 0) {
			if (power.compareTo(BigInteger.valueOf(l)) >= 0) {
				result.add(power.longValue());
			}

			power = power.multiply(BigInteger.valueOf(k));
		}

		return result.isEmpty() ? "-1" : result.stream().map(String::valueOf).collect(Collectors.joining(" "));
	}
}
