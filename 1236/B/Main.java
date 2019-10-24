import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static final int MODULUS = 1_000_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(solve(n, m));

		sc.close();
	}

	static int solve(int n, int m) {
		return BigInteger.valueOf(2).modPow(BigInteger.valueOf(m), BigInteger.valueOf(MODULUS))
				.add(BigInteger.valueOf(MODULUS - 1)).modPow(BigInteger.valueOf(n), BigInteger.valueOf(MODULUS))
				.intValue();
	}
}
