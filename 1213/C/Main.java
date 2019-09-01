import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			long n = sc.nextLong();
			long m = sc.nextLong();

			System.out.println(solve(n, m));
		}

		sc.close();
	}

	static long solve(long n, long m) {
		List<Integer> cycle = findCycle((int) (m % 10));

		return n / m / cycle.size() * cycle.stream().mapToInt(x -> x).sum()
				+ cycle.stream().limit(n / m % cycle.size()).mapToInt(x -> x).sum();
	}

	static List<Integer> findCycle(int step) {
		int digit = 0;
		List<Integer> result = new ArrayList<>();
		while (true) {
			digit = (digit + step) % 10;
			result.add(digit);

			if (digit == 0) {
				return result;
			}
		}
	}
}
