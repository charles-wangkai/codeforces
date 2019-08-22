import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long k = sc.nextLong();
		System.out.println(solve(n, k));

		sc.close();
	}

	static long solve(long n, long k) {
		return (k == 1) ? n : ((1L << String.valueOf(Long.toBinaryString(n)).length()) - 1);
	}
}
