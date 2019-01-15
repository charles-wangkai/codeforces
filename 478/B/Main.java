import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(solve(n, m));

		sc.close();
	}

	static String solve(int n, int m) {
		long minPairNum = computePairNum(n / m) * (m - n % m) + computePairNum(n / m + 1) * (n % m);
		long maxPairNum = computePairNum(n - m + 1);

		return String.format("%d %d", minPairNum, maxPairNum);
	}

	static long computePairNum(int teamSize) {
		return teamSize * (teamSize - 1L) / 2;
	}
}
