import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long x = sc.nextLong();
		long y = sc.nextLong();
		long z = sc.nextLong();
		System.out.println(solve(x, y, z));

		sc.close();
	}

	static String solve(long x, long y, long z) {
		long maxCoconutNum = (x + y) / z;

		long minExchange;
		if (x / z + y / z == maxCoconutNum) {
			minExchange = 0;
		} else {
			minExchange = Math.min(z - x % z, z - y % z);
		}

		return String.format("%d %d", maxCoconutNum, minExchange);
	}
}
