import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();
		System.out.println(solve(n, t));

		sc.close();
	}

	static BigInteger solve(int n, int t) {
		if (n == 1 && t == 10) {
			return BigInteger.valueOf(-1);
		}

		StringBuilder s = new StringBuilder("1");
		while (s.length() < n) {
			s.append(0);
		}

		BigInteger number = new BigInteger(s.toString());
		while (!number.mod(BigInteger.valueOf(t)).equals(BigInteger.ZERO)) {
			number = number.add(BigInteger.ONE);
		}
		return number;
	}
}
