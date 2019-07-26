import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		BigInteger[] lengths = new BigInteger[N];
		for (int i = 0; i < lengths.length; i++) {
			lengths[i] = sc.nextBigInteger();
		}
		System.out.println(solve(lengths));

		sc.close();
	}

	static String solve(BigInteger[] lengths) {
		Arrays.sort(lengths);

		for (int i = 0; i + 2 < lengths.length; i++) {
			if (lengths[i].add(lengths[i + 1]).compareTo(lengths[i + 2]) > 0) {
				return String.format("%d %d %d", lengths[i], lengths[i + 1], lengths[i + 2]);
			}
		}

		return "0 0 0";
	}
}
